package market.priceFeed.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import market.priceFeed.request.dto.UserRequest;
import market.priceFeed.response.dto.UserResponse;
import market.priceFeed.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponse> list() {
        return userService.list();
    }

    @PostMapping
    public void save(@Valid @RequestBody UserRequest request) {
    	userService.save(request);
    }
}