package com.test.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.employees.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{
	@Query(value="Select*From employees_details where age>=?",nativeQuery = true)
	public List<Employees>getByAge(int age);
	@Query(value="Select*From employees_details where name like?",nativeQuery = true)
    public List<Employees>getByName(String name);
	@Query(value="Select*From employees_details where salary>=? and salary<?",nativeQuery = true)
	public List<Employees>getBySalary(int salary,int salary1);
	@Query(value="Select*From employees_details where gender like?",nativeQuery = true)
    public List<Employees>getByGender(String gender);
	@Query(value="Select name From employees_details where id=(select max(id) from employees_details)",nativeQuery = true)
	public String getByMax();
	@Query(value="Select id From employees_details where id=(select min(id) from employees_details)",nativeQuery = true)
	public int getByMin();
		
}
