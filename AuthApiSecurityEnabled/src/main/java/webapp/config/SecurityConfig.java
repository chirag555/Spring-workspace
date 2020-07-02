package webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;
import webapp.services.LoginService;
@Configuration
@EnableWebSecurity
//add extends WebSecurityConfigurerAdapter
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	LoginService loginService;
	
	@Bean
	public AuthenticationProvider authProvider() {		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(loginService);
		//provider.setPasswordEncoder(new BCryptPasswordEncoder());
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http
		.csrf().disable().authorizeRequests()
		.anyRequest().authenticated().and()
		.formLogin()
		.failureHandler(authenticationFailureHandler());		
	}

	private AuthenticationFailureHandler authenticationFailureHandler() {
		return null;
		
	}
	*/
	
	
	
}
