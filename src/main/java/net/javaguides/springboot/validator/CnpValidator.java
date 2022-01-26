package net.javaguides.springboot.validator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import net.javaguides.springboot.exception.InvalidDataException;

public class CnpValidator {

	private static int[] CONTROL_VALUES = new int[] { 2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9 };
	private static int[] YEAR_OFFSET = new int[] { 0, 1900, 1900, 1800, 1800, 2000, 2000 };

	private boolean isValidDistrict(int[] cnpDigits) {
		int jj = cnpDigits[7] * 10 + cnpDigits[8];
		if (jj < 1 || jj > 52 || jj == 49 || jj == 50) {
			return false;
		}
		return true;
	}

	private boolean isValidDate(int[] cnpDigits) {

		int birthDay = cnpDigits[3] * 10 + cnpDigits[4];
		int birthMounth = cnpDigits[5] * 10 + cnpDigits[6];
		int birthYear = YEAR_OFFSET[cnpDigits[0]] + cnpDigits[1] * 10 + cnpDigits[2];

		if (birthDay < 1 && birthDay > 31) {
			return false;
		}

		if (birthMounth < 1 && birthMounth > 12) {
			return false;
		}

		int maxDayOfMonth = new GregorianCalendar(birthYear, birthMounth, birthDay)
				.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (birthDay > maxDayOfMonth) {
			return false;
		}
		return true;
	}

	private boolean isValidLength(int[] cnpDigits) {
		if (cnpDigits.length != 13) {
			throw new InvalidDataException("Account", "CNP", cnpDigits);
		}
		return true;
	}

	private boolean isValidControlSum(int[] cnpDigits) {
		if (cnpDigits[12] != extractControlSum(cnpDigits)) {
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

	private int extractControlSum(int[] twelveDigits) {
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

	public boolean isValid(int[] cnpDigits) {

		isValidLength(cnpDigits);
		isValidGender(cnpDigits);
		isValidDate(cnpDigits);
		isValidDistrict(cnpDigits);
		isValidControlSum(cnpDigits);

		return true;
	}

}
