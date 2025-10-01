package br.ufpb.dcx.dsc.lumiislu.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusValidator.class)
@Documented
public @interface ValidStatus {
    String message() default "Status inválido. Valores permitidos são: ATIVO, INATIVO, ARQUIVADO.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
