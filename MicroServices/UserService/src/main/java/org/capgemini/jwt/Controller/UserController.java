package org.capgemini.jwt.Controller;

import org.capgemini.jwt.Model.RegistrationRequest;
import org.capgemini.jwt.Model.User;
import org.capgemini.jwt.Model.UserRequest;
import org.capgemini.jwt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public String verifyUser(@RequestBody UserRequest request) throws Exception
    {
        return service.verifyUser(request.getUsername(),request.getPassword());
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest request) throws Exception {
        return service.registerUser(request);
    }

    @GetMapping("/profile")
    public String getUserDetails()
    {
        return "hello";
    }



        }
