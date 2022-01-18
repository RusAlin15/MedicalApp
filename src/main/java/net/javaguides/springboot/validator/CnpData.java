package net.javaguides.springboot.validator;

import java.time.LocalDate;

import net.javaguides.springboot.enums.Gender;

public class CnpData {

	private Gender gender;
	private LocalDate birthDate;
	private int age;

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
