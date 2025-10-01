package br.ufpb.dcx.dsc.lumiislu.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Documented
public @interface PasswordStrength {
    String message() default "A senha deve ter entre 6 e 20 caracteres, conter pelo menos uma letra maiúscula, uma minúscula e um número.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
