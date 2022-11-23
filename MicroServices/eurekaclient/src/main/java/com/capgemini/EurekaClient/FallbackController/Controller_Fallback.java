package com.capgemini.EurekaClient.FallbackController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_Fallback {

    @GetMapping("/employeeServiceFallback")
    public String EmployeeServiceFallback()
    {
        return "Server Down Try Later !!";
    }
    @GetMapping("/skillServiceFallback")
    public String SkillServiceFallback()
    {
        return "Server Down Try Later !!";
    }
}
