package com.mvc.dao;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.mvc.model.Employee;
  
@Repository
public class EmployeeDao {
     
    private Map<Integer, Employee> DB = new HashMap<>();
     
    public List<Employee> getEmployeeList() 
    {
        List<Employee> list = new ArrayList<>();
        if(list.isEmpty()) {
            list.addAll(DB.values());
        }
        return list;
    }
     
    public Employee getEmployeeById(int id) {
        return DB.get(id);
    }
     
    public void addEmployee(Employee employee) {
        employee.setEmployeeId(DB.keySet().size() + 1);
        DB.put(employee.getEmployeeId(), employee);
    }
     
    public void updateEmployee(Employee employee) {
        DB.put(employee.getEmployeeId(), employee);
    }
     
    public void deleteEmployee(int id) {
        DB.remove(id);
    }
    public List<Employee> getAllEmployeesFromDb() {

		// To generate the fake details for the employees.
		Faker faker = new Faker();

		// Employee list.
		List<Employee> employeelist = new ArrayList<Employee>();

		// Creating fake employees to be shown on the angular html page.
		for (int i = 101; i <= 110; i++) {

			// Creating employee model objects.
			Employee myemployee = new Employee();
			myemployee.setEmployeeId(i);
			myemployee.setFirstName(faker.name().firstName());
			myemployee.setLastName(faker.name().lastName());
			myemployee.setMobile(faker.phoneNumber().cellPhone());
			myemployee.setAddress(faker.address().streetAddress());
			myemployee.setCompanyLogo(faker.company().logo());

			// Adding the employee records to the employee list.
			employeelist.add(myemployee);
		}

		return employeelist;
	}
}