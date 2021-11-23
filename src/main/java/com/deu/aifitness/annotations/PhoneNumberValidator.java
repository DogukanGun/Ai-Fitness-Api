package com.deu.aifitness.annotations;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Slf4j
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {

    @Override
    public boolean isValid(@NotNull String value, ConstraintValidatorContext context) {
        for (int i = 0; i < value.length(); i++) {
            if ((int)value.toUpperCase().charAt(i)>65 || (int)value.toUpperCase().charAt(i)<90){
                return false;
            }
        }
        return true;
    }
}
