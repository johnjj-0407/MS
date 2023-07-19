package com.test.employees.service;

import java.util.Comparator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.employees.dao.EmployeesDao;
import com.test.employees.entity.Employees;
import com.test.employees.exception.AgeNotException;
import com.test.employees.exception.SalaryNotFoundException;
import com.test.employees.exception.ValueNotFoundException;

@Service
public class EmployeesService {
	@Autowired
	EmployeesDao empDao;
	public String addEmployees(Employees e) {
		return empDao.addEmployees(e);
	}
	public String addAllEmployees(List<Employees> e) {
		return empDao.addAllEmployees(e);

	}
	public Employees findEmployeesId(@PathVariable int id) {
	       
		return empDao.findEmployeesId(id);
	} 
	public List<Employees> findEmployee(@RequestBody List<Employees>e) {
       
		return empDao.findEmployeesId(e);
	}
	public String DeleteEmployeeId(@PathVariable int id) {
	       
		return empDao.DeleteEmployeeId(id);
	}
	public String updateEmployee(@RequestBody Employees id) {
	       
		return empDao.updateEmployee(id);
	}
	public String getHighSalaryEmployee() {
		List<Employees> allEmp=empDao.findEmployee();
		Employees max=allEmp.stream().max(Comparator.comparing(Employees::getSalary)).get();
		
		return max.getName();
	}
	public List<Employees> getAllEmployee() {
		return empDao.getAllEmployee();
	}
	public List<Employees> findByName(@RequestParam String name){
		List<Employees> aemp=empDao.findEmployee();
		return aemp.stream().filter(x->x.getName().equals(name)).toList();
	}
	public List<Employees> findById(@RequestParam Integer age){
		List<Employees> aId=empDao.findEmployee();
		return aId.stream().filter(x->x.getAge()==age).toList();
	}
	public List<Employees> findBySalary(@RequestParam Integer salary,@RequestParam Integer salary1){
		List<Employees> aId=empDao.findEmployee();
		return aId.stream().filter(x->x.getSalary()>=salary && x.getSalary()<salary1).toList();
	}
	public List<Employees>getByAge(int age){
		return empDao.getByAge(age);
	}
	public List<Employees>getByName(String name){
		return empDao.getByName(name);
	}
	public List<Employees>getBySalary(int salary,int salary1){
		return empDao.getBySalary(salary,salary1);
	}
	public List<Employees> getByGender(String gender){
		return empDao.getByGender(gender);
	}
	public String getByMax(){
		return empDao.getByMax();
	}
	public Integer getByMin(){
		return empDao.getByMin();
	}	
	public String ageException(Employees e)throws AgeNotException{
		try {
		if(e.getAge()<18) {
			throw new AgeNotException("Please Enter valid Age");
		}
		else {
			return empDao.ageException(e);
		}
		}
		catch(AgeNotException a) {
			return a.getMessage();
		}
	}
	public List<Employees> getByNames(@RequestBody String name) throws ValueNotFoundException{
		List<Employees>all=empDao.findEmployee();
		List<Employees>nameList=all.stream().filter(x->x.getName().equals(name)).toList();
	
		if(nameList.isEmpty()) {
			throw new ValueNotFoundException("This name not in this table");
		}
		else {
			return nameList;
		
		}
	}
	public List<Employees> getBySalary1()throws SalaryNotFoundException{
		List<Employees>a=empDao.findEmployee();
		List<Employees> salList=a.stream().filter(x->x.getSalary()>=60000).toList();
		if(salList.isEmpty()) {
			throw new SalaryNotFoundException("This salary detail not Found");
		}
		else {
			return salList;
		}			
	}
	

}
