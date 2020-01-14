package com.github.kafka;

public class UnknownEnumValueException extends IllegalArgumentException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownEnumValueException(String enumType, String unknownEnumValue) {
        super(String.format("Enum %s: unknown value %s", enumType, unknownEnumValue));
    }

//    @Override
//    public String getLocalizedMessage() {
//        return "enum.unknown.value";
//    }
}
