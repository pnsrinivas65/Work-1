package com.contacts.person;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class ValidationService {
	private static final Pattern EMAIL_PATTERN = Pattern.compile(
			"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
			Pattern.CASE_INSENSITIVE);

	public void validatePerson(Person person) {
		person.getContacts().forEach(contact -> validateContact(contact));
		boolean oneValidFound = Optional.ofNullable(person).flatMap(p -> Optional.ofNullable(p.getContacts()))
				.map(Collection::stream)
				.filter(contacts -> contacts.anyMatch(contact -> contact.getType() == Contact.ContactType.EMAIL))
				.isPresent();
		if (!oneValidFound)
			throw new ValidationException("Email is required", "at least one contact email is required");
	}

	private boolean isValidEmail(String email) {
		return email != null && EMAIL_PATTERN.matcher(email).matches();
	}

	public void validateEmail(String email) throws ValidationException {
		if (!isValidEmail(email)) {
			throw new ValidationException("Email is required", "email field is empty or invalid");
		}
	}

	public void validateContact(Contact contact) throws ValidationException {
		if (contact.getType() == Contact.ContactType.EMAIL) {
			validateEmail(contact.getContact());
		}
	}
}
