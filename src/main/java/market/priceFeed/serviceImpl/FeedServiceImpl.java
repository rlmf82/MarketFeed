package market.priceFeed.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import market.priceFeed.entity.Feed;
import market.priceFeed.exception.FeedNotFound;
import market.priceFeed.repository.FeedRepository;
import market.priceFeed.request.dto.FeedRequest;
import market.priceFeed.response.dto.FeedResponse;
import market.priceFeed.service.FeedService;
import market.priceFeed.util.BigDecimalUtils;

@Service
public class FeedServiceImpl implements FeedService {

	private final BigDecimal SPREAD_TAX = new BigDecimal(0.001); //0,1%
	
	@Autowired
	private FeedRepository repository;
	
	@Override
	public List<FeedResponse> list(){
		
		List<FeedResponse> response = new ArrayList<>();
		List<Feed> feeds = repository.findAll();
		
		if(feeds != null && !feeds.isEmpty()) {
			response = feeds.stream().map(FeedResponse::transform).collect(Collectors.toList());
		}
		
		return response;
	}
	
	@Override
	public void save(FeedRequest request) {
		repository.save(Feed.transform(request));
	}

	@Override
	public boolean exist(String name) {
		return repository.findByName(name).isPresent();
	}

	@Override
	public String spread(BigDecimal value, String name) throws FeedNotFound {
		Feed feed = null;
		
		BigDecimal variation = value.multiply(SPREAD_TAX);
		Optional<Feed> optFeed = repository.findByName(name);
			
		if(!optFeed.isPresent()) {
			throw new FeedNotFound();
		}
		
		feed = optFeed.get();
		
		feed.setAsk(BigDecimalUtils.format(value.add(variation)));
		feed.setBid(BigDecimalUtils.format(value.subtract(variation)));
		
		repository.saveAndFlush(feed);
		
		return FeedResponse.transform(feed).toString();
	}
}