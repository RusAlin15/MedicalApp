package net.javaguides.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import net.javaguides.springboot.enums.District;
import net.javaguides.springboot.enums.Gender;
import net.javaguides.springboot.validator.CnpValidator;

class CnpValidatorTest {
	CnpValidator junit = new CnpValidator("2930813350017");
	LocalDate expectedLd = LocalDate.of(1993, 8, 15);
	int expectedAge = 28;
	Gender expectedGender = Gender.Male;
	District expectedDistrict = District.Bistrița_Năsăud;

	@Test
	void ageTest() {
		int ageResult = junit.getAge();
		assertEquals(expectedAge, ageResult);
	}

	@Test
	void localDateTest() {
		LocalDate birthDateResult = junit.getBirthDate();
		assertEquals(expectedLd, birthDateResult);
	}

	@Test
	void genderTest() {
		Gender genderResult = junit.getGender();
		assertEquals(expectedGender, genderResult);

	}

	@Test
	void birthDistrictResultTest() {
		District birthDistrictResult = junit.getBirthDistrict();
		assertEquals(expectedDistrict, birthDistrictResult);

	}

}
