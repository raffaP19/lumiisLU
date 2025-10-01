package br.ufpb.dcx.dsc.lumiislu.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StatusValidator implements ConstraintValidator<ValidStatus, String> {

    private final List<String> allowedStatus = Arrays.asList("ATIVO", "INATIVO", "ARQUIVADO");

    @Override
    public boolean isValid(String status, ConstraintValidatorContext context) {
        if (status == null || status.isBlank()) {
            return true;
        }
        return allowedStatus.contains(status.toUpperCase());
    }

}
