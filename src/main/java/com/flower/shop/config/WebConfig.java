package com.flower.shop.config;

import com.flower.shop.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author kamal berriga
 *
 */
@Configurable
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	        }
	    };
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.authorizeRequests()
		.antMatchers("/account/register","/account/login","/logout").permitAll()
		.anyRequest().permitAll().and()
		.logout()
        .permitAll()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
        .and()
		.httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
		.csrf().disable();
	}

}
