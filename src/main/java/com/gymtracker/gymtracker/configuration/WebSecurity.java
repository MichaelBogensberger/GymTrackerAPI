package com.gymtracker.gymtracker.configuration;

import com.gymtracker.gymtracker.security.JWTAuthenticationFilter;
import com.gymtracker.gymtracker.security.JWTAuthorizationFilter;
import com.gymtracker.gymtracker.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {





    public static final String SIGN_UP_URL = "/api/users";

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(
            UserDetailServiceImpl userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailService = userDetailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http.headers().addHeaderWriter(
                new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));

        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests() // Add a new custom security filter
                .antMatchers("/api/createUser").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                //.antMatchers(HttpMethod.POST, SIGN_UP_URL)
                .permitAll() // Only Allow Permission for create user endpoint
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .cors().configurationSource(new CorsConfigurationSource() {

                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.addAllowedOriginPattern("*");
                        config.setAllowCredentials(false);
                        return config;
                    }
                })
                .and()
                .addFilter(this.getJWTAuthenticationFilter()) // Add JWT Authentication Filter
                .addFilter(
                        new JWTAuthorizationFilter(authenticationManager())) // Add JWT Authorization Filter
                .sessionManagement()
                .sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS); // this disables session creation on Spring Security
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();


        configuration.setAllowCredentials(true);
        //configuration.addAllowedOrigin("*");
        configuration.addAllowedOriginPattern("*");

        configuration.setAllowCredentials(true);
        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedMethod("HEAD");
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedMethod("PATCH");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public JWTAuthenticationFilter getJWTAuthenticationFilter() throws Exception {
        final JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/api/login"); // override the default spring login url
        return filter;
    }





}
