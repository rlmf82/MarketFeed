package market.priceFeed.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import market.priceFeed.service.FeedService;
import market.priceFeed.validation.NameAlreadyExist;

public class NameValidator implements ConstraintValidator<NameAlreadyExist, String> {

	@Autowired
	FeedService service;
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	return !service.exist(value);
    }
}
