package comprehensive.com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comprehensive.com.entity.Employee;
import comprehensive.com.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
// build create employee Resttyyu
	@PostMapping()
	public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	//build get all employees Rest emp
	@GetMapping
	public List<Employee>getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	//build get specific id 
@GetMapping("{id}")
	
	public ResponseEntity<Employee> getEmployeeById( @PathVariable("id")int employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
}
//build update employee 
@PutMapping("{id}")
public ResponseEntity<Employee>updateEmployee(@PathVariable("id")int id,@RequestBody Employee employee){
	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	
}
//build delete employee rest api 
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id")int id){
	//delete employee from db 
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!,",HttpStatus.OK);
		
	}
		
		
		
		
	}
	

