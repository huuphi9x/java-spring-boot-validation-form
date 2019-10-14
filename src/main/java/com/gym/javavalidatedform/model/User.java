package com.gym.javavalidatedform.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private int age;

    private String email;

    public User() {
    }

    public User(String firsName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        if (firstName.length() < 5 || firstName.length() > 45) {
            errors.rejectValue("firstName", "name.length");
        }
        if (lastName.length() < 5 || lastName.length() > 45) {
            errors.rejectValue("lastName", "name.length");
        }
        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        if (age < 18) {
            errors.rejectValue("age", "age.min");
        }
        if (!email.matches("(^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(.[A-Za-z0-9]+)$)")) {
            errors.rejectValue("email", "email.matches");
        }
    }
}
