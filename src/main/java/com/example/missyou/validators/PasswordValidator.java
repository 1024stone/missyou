package com.example.missyou.validators;

import com.example.missyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {
    private int min;
    private int max;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(PersonDTO value, ConstraintValidatorContext context) {
        String password1 = value.getPassword1();
        String password2 = value.getPassword2();
        boolean equals = password1.equals(password2);
        return equals;
    }


}
