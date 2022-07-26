package comprehensive.com.service;

import java.util.List;

import comprehensive.com.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee>getAllEmployees();
	Employee getEmployeeById(int  id);
	Employee updateEmployee(Employee employee,int id);
	void deleteEmployee(int id);

}
