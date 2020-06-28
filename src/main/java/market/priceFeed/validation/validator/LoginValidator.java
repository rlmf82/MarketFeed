package market.priceFeed.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import market.priceFeed.service.UserService;
import market.priceFeed.validation.LoginAlreadyExist;

public class LoginValidator implements ConstraintValidator<LoginAlreadyExist, String> {

	@Autowired
	UserService service;
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	return !service.exist(value);
    }
}
