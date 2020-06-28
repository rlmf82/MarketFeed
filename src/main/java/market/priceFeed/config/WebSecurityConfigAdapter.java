package market.priceFeed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import market.priceFeed.entity.User;
import market.priceFeed.repository.UserRepository;
import market.priceFeed.request.dto.UsuarioCustom;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository repositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }
    
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository usuarioRepository) throws Exception {
        if (usuarioRepository.count() == 0) {
            User usuario = new User();
            usuario.setLogin("admin");
            usuario.setPassword(passwordEncoder.encode("admin"));
            usuarioRepository.save(usuario);
        }

        builder.userDetailsService(login -> new UsuarioCustom(repositorio.findByLogin(login)));
    }
    
    @Bean  
    public static BCryptPasswordEncoder passwordEncoder() {  
        return new BCryptPasswordEncoder();  
    }
}