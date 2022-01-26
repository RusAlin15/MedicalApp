package net.javaguides.springboot.service;

import java.time.LocalDate;
import java.time.Period;

import net.javaguides.springboot.enums.Gender;
import net.javaguides.springboot.model.CnpData;

public class CnpDataService {
	/** The standard length of a CNP. */
	public static int LENGTH = 13;

	private static int[] YEAR_OFFSET = new int[] { 0, 1900, 1900, 1800, 1800, 2000, 2000 };

	private static Gender[] GENDER_OFFSET = new Gender[] { null, Gender.Male, Gender.Female, Gender.Male, Gender.Female,
			Gender.Male, Gender.Female };

	private int extractAge(LocalDate birthDate) {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	private Gender extractGender(int[] cnpDigits) {
		return GENDER_OFFSET[cnpDigits[0]];
	}

	public LocalDate extractBirthDate(int[] cnpDigits) {

		int month = cnpDigits[3] * 10 + cnpDigits[4];

		int dayOfMonth = cnpDigits[5] * 10 + cnpDigits[6];

		int year = YEAR_OFFSET[cnpDigits[0]] + cnpDigits[1] * 10 + cnpDigits[2];

		return LocalDate.of(year, month, dayOfMonth);
	}

	public CnpData extract(int[] cnpDigits) {

		Gender gender = extractGender(cnpDigits);
		LocalDate birthDate = extractBirthDate(cnpDigits);
		int age = extractAge(birthDate);

		return new CnpData(gender, birthDate, age);
	}
}
