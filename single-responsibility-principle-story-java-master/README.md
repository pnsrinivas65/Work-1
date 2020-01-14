# Single Responsibility Principle Refactoring Story
**To read the story**: https://refactoringstories.com/file-view/https:%2F%2Fgit.epam.com%2FRefactoring-Stories%2Fsingle-responsibility-principle-story-java

**To code yourself**: https://git.epam.com/Refactoring-Stories/single-responsibility-principle-story-java

**Estimated reading time**: 20 min

## Story Outline
Welcome to refactoring story about Single Responsibility Principle (SRP) for SOLID training course.
This story is about proper decomposition of classes and methods to fit Single Responsibility Principle.
In this story you will see example of web service application that is able to store and manage information
about persons and their contacts. Also you will see application evolution during refactoring 
and improvements steps.

### Contacts Book
Contacts Book is a REST web service which exposes personal data as JSON.
Project is built using Spring Boot framework, so it utilizes simplicity of
coding, deployment, and data exposing using Spring technologies stack. 

Class [Person](/src/main/java/com/contacts/person/Person.java) keeps persons 
information about name, birthday, living address and various contacts like phone and IM.
[Person](/src/main/java/com/contacts/person/Person.java) is exposed as REST resource 
to store and query by personal data using person's email as a primary key.

##### Run application
To run application you have to install Gradle Build Tool from
https://gradle.org/install/
Please make sure that gradle/bin folder is configured in PATH variable.
Run following command and check output to ensure that gradle installed properly
```
gradle -v
```

To run Spring Boot application please swich to your project directory and execute following command:
```
cd single-responsibility-principle-story-java
gradle bootRun
```
Output:
```
> Task :bootRun
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.0.0.RELEASE)
 2018-03-09 11:49:59.158  INFO 21320 --- [main] com.contacts.Application : Starting Application on
 ...
 2018-03-09 11:50:00.163  INFO 21320 --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat initialized with port(s): 8080 (http)
 > :bootRun----> 75% EXECUTING [4s]0 --- [main] com.contacts.Application : Started
```

##### Store new contact
As you see application is listening on port 8080.
To add new contact you should POST request to:
```
http://localhost:8080/person/contact
```
With the following JSON in the body
```
{
    "firstName": "John",
    "lastName": "Doe",
    "birthday": "2000-01-01",
    "contacts" : [{ "type":"EMAIL", "contact":"jdoe@email.dog"}]
}
```

##### Query contact by email
You might query contact by issuing GET request like:
```
http://localhost:8080/person/contact?email=jdoe@email.dog
```
Which might response with following JSON:
```
{
    "firstName": "John",
    "lastName": "Doe",
    "birthday": "2000-01-01",
    "addresses": [],
    "phones": [],
    "contacts": [
        {
            "type": "EMAIL",
            "contact": "jdoe@email.dog"
        }
    ]
}
```
##### Application evolution and extensions planning
At the first glance application is able to fulfill it's goals. But it might be not well
suitable for further evolution and extensions because of many violations.
One of most annoying here is Single Responsibility Principle violation.
Improving only that aspect alone we might dramatically improve application structure
and "fix" other violations.