package br.ufpb.dcx.dsc.lumiislu.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordStrength, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isBlank()) {
            return true;
        }
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$");
    }

}
