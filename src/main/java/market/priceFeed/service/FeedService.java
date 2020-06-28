package market.priceFeed.service;

import java.math.BigDecimal;
import java.util.List;

import market.priceFeed.exception.FeedNotFound;
import market.priceFeed.request.dto.FeedRequest;
import market.priceFeed.response.dto.FeedResponse;

public interface FeedService {

	public List<FeedResponse> list();
	
	public void save(FeedRequest request);
	
	public boolean exist(String name);
	
	public String spread(BigDecimal value, String name) throws FeedNotFound;
}