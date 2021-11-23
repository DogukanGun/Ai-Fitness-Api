package com.deu.aifitness.annotations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "Invalid account type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
