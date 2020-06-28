package market.priceFeed.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import market.priceFeed.exception.FeedNotFound;
import market.priceFeed.request.dto.FeedRequest;
import market.priceFeed.response.dto.FeedResponse;
import market.priceFeed.service.FeedService;

@RestController
@RequestMapping("/feed")
public class FeedController {

	@Autowired
	private FeedService feedService;
	
	@GetMapping("/json")
    public List<FeedResponse> listJson() {
    	return feedService.list();
    }
	
	@GetMapping
    public String list() {
		StringBuilder strReturn = new StringBuilder();
		feedService.list().forEach(strReturn::append);

		return strReturn.toString();
    }
	
    @PostMapping
    public void save(@Valid @RequestBody FeedRequest request) {
    	feedService.save(request);
    }
    
    @PutMapping("/spread")
    public String save(
    		@RequestParam("value") BigDecimal value,
    		@RequestParam("name") String name) throws FeedNotFound {
    	return feedService.spread(value, name);
    }
}