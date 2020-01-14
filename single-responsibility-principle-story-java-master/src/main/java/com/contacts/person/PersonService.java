package com.contacts.person;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private ValidationService validationService;

    @Autowired
    private EmailService emailService;

    private static final Set<Person> persons = new HashSet<>();

    public Person findPersonByEmail(String email) {
        validationService.validateEmail(email);
        return persons.stream()
                .filter(person -> person.getContacts().stream()
                        .anyMatch(contact ->
                                contact.getType() == Contact.ContactType.EMAIL
                                        && contact.getContact().equalsIgnoreCase(email)))
                .findFirst().orElse(null);
    }

    public void store(Person person) {
        validationService.validatePerson(person);
        persons.add(person);
        emailService.sendGreetingEmail(person);
    }
}
