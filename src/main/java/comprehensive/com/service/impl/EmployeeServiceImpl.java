package comprehensive.com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import comprehensive.com.entity.Employee;
import comprehensive.com.exception.ResourceNotFoundException;
import comprehensive.com.repository.EmployeeRepository;
import comprehensive.com.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	


	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
			return employeeRepository.findAll();
		}



	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
	
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
	}



	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//we need to check wheter employee with given salary exit or not
    Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()
		-> new ResourceNotFoundException("Employee","Id",id));
				existingEmployee.setName(employee.getName());
				existingEmployee.setSalary(employee.getSalary());
				existingEmployee.setDesignation(employee.getDesignation());
			employeeRepository.save(existingEmployee);
			return existingEmployee;
				}
	



	@Override
	public void deleteEmployee(int id) {
		// check whether a database exit or not
				employeeRepository.findById(id).orElseThrow(()
						-> new ResourceNotFoundException("Employee","Id",id));
				employeeRepository.deleteById(id);
			}
				
		
	}



