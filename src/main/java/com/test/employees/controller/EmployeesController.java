package com.test.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.employees.entity.Employees;
import com.test.employees.exception.AgeNotException;
import com.test.employees.exception.SalaryNotFoundException;
import com.test.employees.exception.ValueNotFoundException;
import com.test.employees.service.EmployeesService;

@RestController
public class EmployeesController {
	@Autowired
	EmployeesService empSer;
	@Autowired
	RestTemplate rt;
	@GetMapping(path="/getString")
		public String getString() {
			String url="http://localhost:8080/hi";
			ResponseEntity<String>s=rt.exchange(url,HttpMethod.GET,null,String.class);
			String x=s.getBody();
			return x.toUpperCase();
		}

	@PostMapping(value = "/insertEmployees")
	public String addEmployees(@RequestBody Employees e) {
		return empSer.addEmployees(e);
	}

	@PostMapping(value = "/insertAllEmployees")
	public String addAllEmployees(@RequestBody List<Employees> e) {

		return empSer.addAllEmployees(e);
	}
	@GetMapping(value = "/findEmployees/{id}")
	public Employees findEmployeesId(@PathVariable int id) {
       
		return empSer.findEmployeesId(id);
	}
	@GetMapping(value = "/findEmployee")
	public List<Employees> findEmployee(@RequestBody List<Employees>e) {
       
		return empSer.findEmployee(e);
	}
	@DeleteMapping(value = "/DeleteEmployee/{id}")
	public String DeleteEmployeeId(@PathVariable int id) {
       
		return empSer.DeleteEmployeeId(id);
	}
	@PutMapping(value = "/updateEmployee/{id}")
	public String updateEmployee(@RequestBody Employees id) {
       
		return empSer.updateEmployee(id);
	}
	@GetMapping(value="/highSalariedEmployeeName")
	public String getHighSalaryEmployee() {
		return empSer.getHighSalaryEmployee();
	}
	@GetMapping(value="/AllEmployee")
	public List<Employees> getAllEmployee() {
		return empSer.getAllEmployee();
	}
	@GetMapping(value="/findByName")
	public List<Employees> findByName(@RequestParam String name){
		return empSer.findByName(name);
	}
	@GetMapping(value="/findByAge")
	public List<Employees> findById(@RequestParam Integer age){
		return empSer.findById(age);
	}
	@GetMapping(value="/findBySalary")
	public List<Employees> findBySalary(@RequestParam Integer salary,@RequestParam Integer salary1){
		return empSer.findBySalary(salary,salary1);
	}
	@GetMapping(value="/getByAge")
	public List<Employees>getByAge(@RequestParam int age){
		return empSer.getByAge(age);
	}
	@GetMapping(value="/getByName")
	public List<Employees>getByName(@RequestParam String name){
		return empSer.getByName(name);
	}
	@GetMapping(value="/getBySalary")
	public List<Employees>getBySalary(@RequestParam int salary,int salary1){
		return empSer.getBySalary(salary,salary1);
	}
	@GetMapping(value="/getByGender")
	public List<Employees> getByGender(@RequestParam String gender){
		return empSer.getByGender(gender);
	}
	@GetMapping(value="/getSenior")
	public String getByMax(){
		return empSer.getByMax();
	}
	@GetMapping(value="/getjunior")
	public Integer getByMin(){
		return empSer.getByMin();
	}
	@PostMapping(value="/ageException")
	public String ageException(@RequestBody Employees e)throws AgeNotException{
		return empSer.ageException(e);
		
	}
	@GetMapping(value="/nameException")
	public List<Employees> getByNames(@RequestParam String name) throws ValueNotFoundException{
		return empSer.getByNames(name);
	}
	@GetMapping(value="/salaryException")
	public List<Employees> getBySalary1() throws SalaryNotFoundException{
		return empSer.getBySalary1();
	}
	
	
	
}
