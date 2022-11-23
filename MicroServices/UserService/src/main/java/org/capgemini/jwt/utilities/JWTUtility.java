package org.capgemini.jwt.utilities;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.capgemini.jwt.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;
import static java.util.Arrays.stream;

@Component
@Slf4j
public class JWTUtility {


    private JWTVerifier verifier;

    public JWTUtility(JWTVerifier verifier) {
        this.verifier = verifier;
    }



    public String generateToken(User user)
    {
        String[] claims = getClaimsFromUser(user);
        return JWT.create().withIssuer("User-Service")
                .withArrayClaim("Authority",claims)
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+5*60*1000))
                .sign(Algorithm.HMAC512(Base64.getDecoder().decode("secret")));
    }

    public List<GrantedAuthority> getAuthoritiesFromToken(String token)
    {
         String[] claims = getClaimsFromToken(token);
         return stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }



    public String[] getClaimsFromToken(String token) {

        return verifier.verify(token).getClaim("Authority").asArray(String.class);
    }


    private String[] getClaimsFromUser(User user) {
        List<String> authorities = new ArrayList<>();
        for(GrantedAuthority authority : user.getAuthorities())
        {
            authorities.add(authority.getAuthority());
        }
        return authorities.toArray(new String[0]);
    }

    public Authentication getAuthentication(String  user,
                                            List<GrantedAuthority> authorities, HttpServletRequest request){
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(user,null,authorities);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return authenticationToken;
    }

    public Boolean isTokenValid(String username,String token)
    {
        return StringUtils.isNotBlank(username) && isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {

        return verifier.verify(token).getExpiresAt().after(new Date());
    }

    public String getSubjectFromToken(String token)
    {

        return verifier.verify(token).getSubject();
    }
}
