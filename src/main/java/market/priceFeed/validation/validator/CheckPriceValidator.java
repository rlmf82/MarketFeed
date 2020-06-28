package market.priceFeed.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import market.priceFeed.request.dto.FeedRequest;
import market.priceFeed.validation.CheckPrice;

public class CheckPriceValidator implements ConstraintValidator<CheckPrice, FeedRequest> {

    @Override
    public boolean isValid(FeedRequest value, ConstraintValidatorContext context) {
    	return value.getBid().compareTo(value.getAsk()) < 0;
    }
}
