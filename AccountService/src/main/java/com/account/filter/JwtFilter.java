package com.account.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@PropertySource("classpath:Configurations.properties")
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    RestTemplate restTemplate;
    @Value("${JwtFilter.ValidateToken}")
    String url;
    @Value("${UserController.CreateUsers}")
    String createUser;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("URI -->"+ httpServletRequest.getRequestURI());
        if(httpServletRequest.getRequestURI().equals(createUser) || httpServletRequest.getRequestURI().contains("/h2-console") ) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        HttpHeaders header = new HttpHeaders();
        header.set("Content-Type", "application/json");
        header.set("Authorization", httpServletRequest.getHeader("Authorization"));
        HttpEntity entity = new HttpEntity<>(header);
        //ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Boolean.class);
        //System.out.println(responseEntity.getBody());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
