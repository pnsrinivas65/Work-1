package com.contacts.person;

import java.util.Objects;

public class Contact {
    public enum ContactType {
        EMAIL,
        SKYPE,
        FACEBOOK,
        LINKEDIN
    }

    private ContactType type;
    private String contact;

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact1 = (Contact) o;
        return type == contact1.type &&
                Objects.equals(contact, contact1.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, contact);
    }
}
