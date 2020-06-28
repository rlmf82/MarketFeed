package market.priceFeed.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import market.priceFeed.validation.validator.CheckPriceValidator;

@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPriceValidator.class)
@Documented
public @interface CheckPrice {

    String message() default "The ask price must be higher than bid price.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}