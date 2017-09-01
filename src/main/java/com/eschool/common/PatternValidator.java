package com.eschool.common;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.PatternSyntaxException;

public class PatternValidator implements ConstraintValidator<Pattern, String> {

    @Override
    public void initialize(Pattern pattern) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if ( value == null || value.length() == 0 ) {
            return true;
        }

        try {
            java.util.regex.Pattern.compile(value);
            return true;
        } catch (PatternSyntaxException exception) {
            return false;
        }
    }

}