package org.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addSkill")
    public EmployeeSkill addEmployee(@RequestBody EmployeeSkill employee)
    {
        return service.addEmployee(employee);
    }

    @GetMapping("/showAll/{id}")
    public EmployeeSkill showAllEmployees(@PathVariable("id") Long Id) throws Exception {
        return  service.showAllEmployee(Id);
    }

    @PutMapping("/update/{id}")
    public EmployeeSkill updateSkill(@RequestBody List<String> skill, @PathVariable("id") Long id) throws EmployeeNotFoundException {
        return service.updateSkill(skill,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return service.deleteEmployee(id);
    }
}
