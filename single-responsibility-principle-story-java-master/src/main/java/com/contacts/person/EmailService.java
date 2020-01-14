package com.contacts.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Value("${owner.name:John Doe}")
    private String ownerName;
    @Value("${owner.email:jdoe@gmail.com}")
    private String ownerEmail;
    @Value("${email.greeting.subject:Your email contact was added to contacts}")
    private String emailSubject;

    public void sendGreetingEmail(Person person){
        try {
            String body = prepareEmailBody(person, "greetTemplate");
            MimeMessage mimeMessage = prepareMimeMessage(person, body);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Email sending error: ", e);
        }
    }

    private String extractEmail(Person person) {
        return person.getContacts()
                .stream()
                .filter(contact -> contact.getType() == Contact.ContactType.EMAIL)
                .findFirst().get().getContact();
    }

    private MimeMessage prepareMimeMessage(Person person, String body) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject(emailSubject);
        message.setFrom(ownerEmail);
        message.setTo(extractEmail(person));
        message.setText(body);
        return mimeMessage;
    }

    private String prepareEmailBody(Person person, String template) {
        Context context = new Context();
        context.setVariable("FirstName", person.getFirstName());
        context.setVariable("LastName", person.getLastName());
        context.setVariable("OwnerName", ownerName);
        context.setVariable("OwnerEmail", ownerEmail);
        return templateEngine.process(template, context);
    }
}
