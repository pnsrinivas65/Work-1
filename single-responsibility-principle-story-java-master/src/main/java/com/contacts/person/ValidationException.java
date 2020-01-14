package com.contacts.person;

public class ValidationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 866544535381333951L;
	private String description;

    public ValidationException(String msg, String description){
        super(msg);
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
