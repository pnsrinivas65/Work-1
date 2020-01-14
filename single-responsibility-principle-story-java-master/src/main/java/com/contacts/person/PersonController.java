package com.contacts.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    class OperationStatus {
        private String message;
        private String details;

        public OperationStatus(String message) {
            this.message = message;
        }

        public OperationStatus(String message, String details) {
            this.message = message;
            this.details = details;
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    ResponseEntity findByEmail(@RequestParam(value = "email") String email){
        return ResponseEntity.ok(personService.findPersonByEmail(email));
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ResponseEntity storePerson(@RequestBody Person person){
        personService.store(person);
        return ResponseEntity.ok(new OperationStatus(HttpStatus.OK.name()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleException(ValidationException ex) {
        return ResponseEntity
                .badRequest()
                .body(new OperationStatus(ex.getMessage(), ex.getDescription()));
    }
}
