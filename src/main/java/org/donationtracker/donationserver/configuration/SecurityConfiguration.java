package org.donationtracker.donationserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected  void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/h2-console").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/test").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/test2").permitAll();
        httpSecurity.csrf().disable();

        httpSecurity.headers().frameOptions().disable();
    }
}
