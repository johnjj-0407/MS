package com.test.employees.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.test.employees.entity.Employees;
import com.test.employees.repository.EmployeesRepository;

@Repository
public class EmployeesDao {
	@Autowired
	EmployeesRepository empRepo;
	public String addEmployees(Employees e) {
		empRepo.save(e);
		return "Successfully Saved";
	}
	public String addAllEmployees(List<Employees> e) {
		empRepo.saveAll(e);
		return "Successfully Saved";
	}
	public Employees findEmployeesId(@PathVariable int id) {
	       
		return empRepo.findById(id).get();
		 
	}
	public List<Employees> findEmployee() {
       
		return empRepo.findAll();
	}
	public String DeleteEmployeeId(@PathVariable int id) {
	      
		empRepo.deleteById(id);
		return "SuccessFully Deleted";
	}
	public String updateEmployee(@RequestBody Employees id) {
	       
		 empRepo.save(id);
		 return "Successfully Updated";
	}
	public List<Employees> findEmployeesId(List<Employees> e) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employees> getAllEmployee() {
		return empRepo.findAll();
	}
	public List<Employees>getByAge(int age){
		return empRepo.getByAge(age);
	}
	public List<Employees>getByName(String name){
		return empRepo.getByName(name);
	}
	public List<Employees>getBySalary(int salary,int salary1){
		return empRepo.getBySalary(salary,salary1);
	}
	public List<Employees> getByGender(String gender){
		return empRepo.getByGender(gender);
	}
	public String getByMax(){
		return empRepo.getByMax();
	}
	public Integer getByMin(){
		return empRepo.getByMin();
	}
	public String ageException(Employees e) {
		 empRepo.save(e);
		 return "Successfully Saved";
	}
}
