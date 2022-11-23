package org.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements  EmployeeService{

    @Autowired
    private EmployeeRepository repository;
    @Override
    public EmployeeSkill addEmployee(EmployeeSkill employee) {
        return repository.save(employee);
    }

    @Override
    public EmployeeSkill showAllEmployee(Long id) throws Exception {
        EmployeeSkill employee = repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("not found"));
        return employee;
    }


    @Override
    public String deleteEmployee(Long id) throws EmployeeNotFoundException {
        EmployeeSkill employee = repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("not found"));
        repository.delete(employee);
        return "successfully deleted";
    }

    @Override
    public EmployeeSkill updateSkill(List<String> skill, Long id) throws EmployeeNotFoundException {
        EmployeeSkill employeeSkill = repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("not found"));
        employeeSkill.setSkills(skill);
        return repository.save(employeeSkill);
    }
}
