package com.example.formvalidation.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    @NotBlank
    @Size(min = 5,max = 45,message = "Nhập tên không đúng chuẩn")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45,message = "Nhập tên không dúng chuẩn")
    private String lastName;


    private String phoneNumber;


    private String age;

    @Email
    private String email;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
            UserDto userDto =(UserDto) target;
        String number = userDto.getPhoneNumber();
        String age = userDto.getAge();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "number.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber", "number.length","Khong nhap duoc so");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "number.startsWith","Khong nhap duoc so");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "number.matches","Khong nhap duoc so");
        }
        if (Integer.parseInt(age)<18){
            errors.rejectValue("age","age","tuoi phai lon hon 18");
        }
    }
}
