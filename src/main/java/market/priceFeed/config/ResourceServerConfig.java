package market.priceFeed.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

    	http.headers().frameOptions().disable();
    	
    	http.authorizeRequests()
        	
        	.antMatchers(HttpMethod.GET, "/market/oauth/token").permitAll()
            .antMatchers(HttpMethod.POST, "/market/user").permitAll()
            .antMatchers(HttpMethod.GET, "/market/user").authenticated();
    }
}