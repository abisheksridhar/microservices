package org.capgemini.jwt.Service;

import lombok.AllArgsConstructor;
import org.capgemini.jwt.Model.RegistrationRequest;
import org.capgemini.jwt.Model.User;
import org.capgemini.jwt.Repository.UserRepo;
import org.capgemini.jwt.utilities.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTUtility utility;

    @Autowired
    PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Not found"));
    }

    public String verifyUser(String username, String Password) throws UsernameNotFoundException
    {
        String jwtToken = null;
        User user = repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));
        if(encoder.matches(Password,user.getPassword()))
        {
            jwtToken = utility.generateToken(user);
        }
        return jwtToken;
    }

    public String registerUser(RegistrationRequest request) throws Exception {
        if(!repo.findByUsername(request.getUsername()).isPresent()){
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(encoder.encode(request.getPassword()));
            user.setFirstName(request.getFirstname());
            user.setLastName(request.getLastname());
            user.setRole(request.getRole());
            user.setIsLocked(false);
            user.setIsEnabled(true);
            repo.save(user);
            return "User Registered Successfully";
        }
        else
            throw new Exception("Username Already Exist in database");
    }
}
