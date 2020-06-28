package market.priceFeed.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import market.priceFeed.request.dto.UserRequest;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String login;
    
    private String password;

    public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static User transform(UserRequest request, PasswordEncoder passwordEncoder) {
		User user = new User();
		user.setLogin(request.getLogin());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		return user;
	}
}