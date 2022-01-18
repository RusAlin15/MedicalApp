package net.javaguides.springboot.model;

import java.time.LocalDate;

import net.javaguides.springboot.enums.Gender;

public class CnpData {

	private Gender gender;
	private LocalDate birthDate;
	private int age;

	public CnpData(Gender gender, LocalDate birthDate, int age) {
		super();
		this.gender = gender;
		this.birthDate = birthDate;
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public int getAge() {
		return age;
	}

}
