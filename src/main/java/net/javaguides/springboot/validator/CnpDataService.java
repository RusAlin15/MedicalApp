package net.javaguides.springboot.validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

import net.javaguides.springboot.enums.Gender;
import net.javaguides.springboot.exception.InvalidDataException;

public class CnpDataService {
	/** The standard length of a CNP. */
	public static int LENGTH = 13;

	private static int[] CONTROL_VALUES = new int[] { 2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9 };

	private static int[] YEAR_OFFSET = new int[] { 0, 1900, 1900, 1800, 1800, 2000, 2000 };

	private static Gender[] GENDER_OFFSET = new Gender[] { null, Gender.Male, Gender.Female, Gender.Male, Gender.Female,
			Gender.Male, Gender.Female };

	private int extractAge(LocalDate birthDate) {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	private Gender extractGender(int[] cnpDigits) {
		return GENDER_OFFSET[cnpDigits[0]];
	}

	private int[] setCnpDigits(String cnp) {

		int[] digits = new int[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			char c = cnp.charAt(i);
			if (!Character.isDigit(c)) {
				throw new InvalidDataException("Account", "CNP", cnp);
			}
			digits[i] = (byte) Character.digit(c, 10);
		}
		return digits;
	}

	private static int extractControlSum(int[] twelveDigits) {
		int k = 0;
		for (int i = 0; i < 12; i++) {
			k += CONTROL_VALUES[i] * twelveDigits[i];
		}
		k %= 11;
		if (k == 10) {
			k = 1;
		}
		return k;
	}

	public LocalDate extractBirthDate(int[] cnpDigits) {

		int month = cnpDigits[3] * 10 + cnpDigits[4];

		int dayOfMonth = cnpDigits[5] * 10 + cnpDigits[6];

		int year = YEAR_OFFSET[cnpDigits[0]] + cnpDigits[1] * 10 + cnpDigits[2];

		if (!isValidDate(month, dayOfMonth, year))
			throw new InvalidDataException("Account", "CNP", cnpDigits.toString());

		return LocalDate.of(year, month, dayOfMonth);
	}

	private boolean isValidDistrict(int[] cnpDigits) {
		int jj = cnpDigits[7] * 10 + cnpDigits[8];
		if (jj < 1 || jj > 52 || jj == 49 || jj == 50) {
			return false;
		}
		return true;
	}

	private boolean isValidDate(int month, int dayOfMonth, int year) {
		if (dayOfMonth < 1 && dayOfMonth > 31) {
			return false;
		}

		if (month < 1 && month > 12) {
			return false;
		}

		int maxDayOfMonth = new GregorianCalendar(year, month, dayOfMonth).getActualMaximum(Calendar.DAY_OF_MONTH);
		if (dayOfMonth > maxDayOfMonth) {
			return false;
		}
		return true;
	}

	private void isValidLength(String cnp) {
		if (cnp.length() != LENGTH) {
			throw new InvalidDataException("Account", "CNP", cnp);
		}
	}

	private boolean isValidControlSum(int[] cnpDigits) {
		if (cnpDigits[LENGTH - 1] != extractControlSum(cnpDigits)) {
			throw new InvalidDataException("Account", "CNP", cnpDigits.toString());
		}
		return true;
	}

	private boolean isValidGender(int[] cnpDigits) {
		if (cnpDigits[0] < 1 || cnpDigits[0] > 6) {
			throw new InvalidDataException("Account", "CNP", cnpDigits.toString());
		}
		return true;

	}

	public CnpData extract(String cnp) {
		CnpData cnpData = new CnpData();

		isValidLength(cnp);
		int[] cnpDigits = setCnpDigits(cnp);

		isValidGender(cnpDigits);
		isValidControlSum(cnpDigits);
		isValidDistrict(cnpDigits);

		cnpData.setGender(extractGender(cnpDigits));

		LocalDate birthDate = extractBirthDate(cnpDigits);
		cnpData.setBirthDate(birthDate);
		cnpData.setAge(extractAge(birthDate));

		return cnpData;
	}
}
