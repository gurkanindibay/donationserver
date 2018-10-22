package org.donationtracker.donationserver.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //@Autowired
    private final AuthenticationProvider authenticationProvider;

    //@Autowired
    private final JsonBasicAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfiguration(AuthenticationProvider authenticationProvider,
            JsonBasicAuthenticationEntryPoint jsonBasicAuthenticationEntryPoint) {
        this.authenticationProvider = authenticationProvider;
        this.authenticationEntryPoint = jsonBasicAuthenticationEntryPoint;
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/h2-console").permitAll();
//        //httpSecurity.authorizeRequests().antMatchers("/test").permitAll();
//        //h   ttpSecurity.authorizeRequests().antMatchers("/test2").permitAll();
//        httpSecurity.csrf().disable();
//        httpSecurity.authorizeRequests().anyRequest().authenticated();
//
//        httpSecurity.headers().frameOptions().disable();

        // @formatter:off
        httpSecurity.headers()
            .and().cors().disable().csrf().disable().requestCache().requestCache(new NullRequestCache())
            .and().logout().invalidateHttpSession(true)
            .and().authorizeRequests().antMatchers("/h2-console/*").permitAll()
            .and().authorizeRequests().anyRequest().authenticated()
            .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint)
            .and().anonymous().disable().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and().headers().frameOptions().disable();
        // @formatter:on
    }
}
