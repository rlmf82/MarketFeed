package market.priceFeed.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import market.priceFeed.entity.User;
import market.priceFeed.repository.UserRepository;
import market.priceFeed.request.dto.UserRequest;
import market.priceFeed.response.dto.UserResponse;
import market.priceFeed.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public List<UserResponse> list() {
		List<User> users = userRepository.findAll();
		List<UserResponse> response = new ArrayList<>();
		
		if(users != null && !users.isEmpty()) {
			response = users.stream().map(UserResponse::tranform).collect(Collectors.toList());
		}
		
		return response;
	}

	@PostMapping
	public void save(UserRequest request) {
		userRepository.saveAndFlush(User.transform(request, passwordEncoder));
	}

	@Override
	public boolean exist(String login) {
		return userRepository.exist(login).isPresent();
	}
}