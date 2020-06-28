package market.priceFeed.service;

import java.util.List;

import market.priceFeed.request.dto.UserRequest;
import market.priceFeed.response.dto.UserResponse;

public interface UserService {

    public List<UserResponse> list();

    public void save(UserRequest usuario);
	
    public boolean exist(String login);
}
