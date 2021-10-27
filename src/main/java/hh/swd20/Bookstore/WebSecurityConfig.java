package hh.swd20.Bookstore;

// import java.util.ArrayList;
// import java.util.List;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.swd20.Bookstore.web.UserDetailServiceImpl;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
    private UserDetailServiceImpl userDetailsService;	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/css/**", "/webjars/**", "/booklist").permitAll()
			.and()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/booklist", true)
			.permitAll()
			.and()
		.logout().permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() {
	 * 
	 * 
	 * 
	 * List<UserDetails> users = new ArrayList();
	 * 
	 * UserDetails user = User.withDefaultPasswordEncoder() .username("user")
	 * .password("user") .roles("USER") .build(); users.add(user);
	 * 
	 * UserDetails admin = User.withDefaultPasswordEncoder() .username("admin")
	 * .password("admin") .roles("ADMIN") .build(); users.add(admin);
	 * 
	 * return new InMemoryUserDetailsManager(users);
	 * 
	 * }
	 */
}
