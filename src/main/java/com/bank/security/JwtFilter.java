package com.bank.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class JwtFilter implements Filter 
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("JWT FILTER RUNNING");
		HttpServletRequest req=(HttpServletRequest) request;
		String header=req.getHeader("Authorization");
		
		if(header != null && header.startsWith("Bearer ")){

            String token = header.substring(7);

            String email=JwtUtil.extractEmail(token);
            
            UsernamePasswordAuthenticationToken auth =
	                new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());

	        SecurityContextHolder.getContext().setAuthentication(auth);
        }
		
		
	    

        chain.doFilter(request,response);
		
	}

	
}
