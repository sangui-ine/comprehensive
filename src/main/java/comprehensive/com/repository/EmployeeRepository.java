package comprehensive.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comprehensive.com.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
