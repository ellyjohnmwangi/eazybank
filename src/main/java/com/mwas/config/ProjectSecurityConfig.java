package com.mwas.config;

import java.util.Arrays;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     *  /myAccount -secured
     *  /myBalance -secured
     *  /myLoans -secured
     *  /myCards -secured
     *  /notices -not secured
     *  /contacts -not secured
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * custom configurations
         * */
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config =new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setExposedHeaders(Arrays.asList("Authorization"));
                config.setMaxAge(3600l);
                return config;
            }
        }).and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/myAccount").hasRole("USER")
                .antMatchers("/myLoans").hasRole("ROOT")
                .antMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
                .antMatchers("/myCards").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and().
//                formLogin().and().
                httpBasic();
        /**
         * Configuration  to deny all the request
         * */
//        http
//                .authorizeRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();
        /**
         * Configuration to permit all requests
         * */
//        http
//                .authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();

        }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("12345")
//                .authorities("admin").and().withUser("user").password("12345")
//                .authorities("read").and().passwordEncoder(NoOpPasswordEncoder.getInstance());

//    }
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
    //     UserDetails user = User.withUsername("admin").password("12345").authorities("admin").build();
    //     UserDetails user1 = User.withUsername("user").password("12345").authorities("read").build();
    //     userDetailsService.createUser(user);
    //     userDetailsService.createUser(user1);
    //     auth.userDetailsService(userDetailsService);



    // }
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
