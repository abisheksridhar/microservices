package org.capgemini.jwt.utilities;

import lombok.extern.slf4j.Slf4j;
import org.capgemini.jwt.Model.User;
import org.capgemini.jwt.Service.UserService;
import org.capgemini.jwt.utilities.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
@Slf4j
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtility utility;

    public JWTAuthorizationFilter(JWTUtility jwtUtility) {
        this.utility = jwtUtility;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
       String[] allowedUrls = {"/user/login","/user/register"};
       return stream(allowedUrls).anyMatch((url)->new AntPathRequestMatcher(url).matches(request));
    }

    UserService getUserService()
    {
        return new UserService();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getMethod().equalsIgnoreCase("OPTIONS"))
        {
            response.setStatus(HttpStatus.OK.value());
        }
        else {
            String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
            if(authorization != null && authorization.startsWith("Bearer"))
            {
                String token = authorization.substring(7);
                String username = utility.getSubjectFromToken(token);
                if(utility.isTokenValid(username,token))
                {
                    List<GrantedAuthority> authorities = utility.getAuthoritiesFromToken(token);
                    SecurityContextHolder.getContext().setAuthentication(utility.getAuthentication
                                                        (username,authorities,request));
                    filterChain.doFilter(request,response);
                    return;
                }
            }
            else {
                response.setStatus(500);
            }
        }
    }
}
