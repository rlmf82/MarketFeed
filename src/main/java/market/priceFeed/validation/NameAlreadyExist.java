package market.priceFeed.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import market.priceFeed.validation.validator.NameValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface NameAlreadyExist {

    String message() default "Name already being used.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}