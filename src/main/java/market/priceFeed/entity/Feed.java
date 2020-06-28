package market.priceFeed.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import market.priceFeed.request.dto.FeedRequest;

@Entity
@Table(name = "feed")
public class Feed implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;

    private String name;
    
    private BigDecimal bid;
    
    private BigDecimal ask;

    private LocalDateTime timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public static Feed transform(FeedRequest request) {
		
		Feed feed = new Feed();
		feed.setName(request.getName());
		feed.setAsk(request.getAsk());
		feed.setBid(request.getBid());
		feed.setTimestamp(request.getTimestamp());
		
		return feed;
	}
}