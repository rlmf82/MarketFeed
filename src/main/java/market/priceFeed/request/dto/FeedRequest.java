package market.priceFeed.request.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import market.priceFeed.validation.CheckPrice;
import market.priceFeed.validation.NameAlreadyExist;

@CheckPrice
public class FeedRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@NameAlreadyExist
	@NotNull(message = "Name may not be empty or null")
	@NotEmpty(message = "Name may not be empty or null")
	@Pattern(regexp="^[A-Z]{3}+[\\/]+[A-Z]{3}$", message = "Pattern must be like EUR/USB")
	private String name;
	
	@NotNull(message = "Bid may not be empty or null")
	private BigDecimal bid;

	@NotNull(message = "Ask may not be empty or null")
	private BigDecimal ask;
	
	@NotNull(message = "Timestamp may not be empty or null")
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
}