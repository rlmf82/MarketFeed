package market.priceFeed.response.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import market.priceFeed.entity.Feed;
import market.priceFeed.util.TimestampUtils;

public class FeedResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private BigDecimal bid;

	private BigDecimal ask;

	private LocalDateTime timestamp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static FeedResponse transform(Feed feed) {

		FeedResponse response = new FeedResponse();
		response.setAsk(feed.getAsk());
		response.setBid(feed.getBid());
		response.setId(feed.getId());
		response.setName(feed.getName());
		response.setTimestamp(feed.getTimestamp());
		
		return response;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + bid + ", " + ask + ", " + TimestampUtils.format(timestamp) + "\n";
	}
}