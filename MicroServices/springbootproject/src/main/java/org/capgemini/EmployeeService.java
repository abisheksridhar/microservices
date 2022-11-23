package org.capgemini;

import java.util.List;

public interface EmployeeService {
    EmployeeSkill addEmployee(EmployeeSkill employee);

    EmployeeSkill showAllEmployee(Long id) throws Exception;

    String deleteEmployee(Long id) throws EmployeeNotFoundException;

    EmployeeSkill updateSkill(List<String> skill, Long id) throws EmployeeNotFoundException;
}
