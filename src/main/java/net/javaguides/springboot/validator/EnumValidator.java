package net.javaguides.springboot.validator;

public class EnumValidator {

	public EnumValidator() {
		super();
	}

	public <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
		for (E e : enumClass.getEnumConstants()) {
			if (e.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
