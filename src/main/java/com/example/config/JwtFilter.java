package com.example.config;

import java.io.IOException; 

import javax.servlet.FilterChain; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean; 
 
import io.jsonwebtoken.Claims; 
import io.jsonwebtoken.Jwts; 
import io.jsonwebtoken.SignatureException; 


/**
 * Las peticiones que no sean /login pasarán por este filtro
 * el cuál se encarga de pasar el "request" a nuestra clase de utilidad JwtUtil
 * para que valide el token.
 */
public class JwtFilter extends GenericFilterBean { 
 
	 /*  @Override 
    public void doFilter(final ServletRequest req, 
                         final ServletResponse res, 
                         final FilterChain ) throws IOException, ServletException { 
      final HttpServletRequest request = (HttpServletRequest) req; 
 
        final String authHeader = request.getHeader("Authorization"); 
        if (authHeader == null || !authHeader.startsWith("Bearer ")) { 
            throw new ServletException("Missing or invalid Authorization header."); 
        } 
 
        final String token = authHeader.substring(7); // The part after "Bearer " 
 
        try { 
            final Claims claims = Jwts.parser().setSigningKey("secretkey") 
                .parseClaimsJws(token).getBody(); 
            request.setAttribute("claims", claims); 
        } 
        catch (final SignatureException e) { 
            throw new ServletException("Invalid token."); 
        } 
 
        chain.doFilter(req, res); 
    } */
    	
    	
	@Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {


        Authentication authentication = JwtUtil.getAuthentication((HttpServletRequest)request);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request,response);
    }
    	
    	
}
    	
