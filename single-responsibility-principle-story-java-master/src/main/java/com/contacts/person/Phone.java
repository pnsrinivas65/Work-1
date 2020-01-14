package com.contacts.person;

public class Phone {
    public enum PhoneType {
        PRIMARY,
        HOME,
        WORK,
        MOBILE
    }

    private PhoneType type;
    private String number;

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
