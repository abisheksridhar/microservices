package org.capgemini.jwt.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    @SequenceGenerator(name = "userIdGenerator", sequenceName = "userId", initialValue = 100000, allocationSize = 1)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(unique = true,updatable = false,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean isEnabled;

    private Boolean isLocked;

    @Override
    public  String getPassword(){
        return this.password;
    }

    @Override
    public  String getUsername(){
        return this.username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return stream(this.role.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        //return stream(this.role.getAuthorities()).map((authority)->new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
