package com.bikkadit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.model.Employee;
import com.bikkadit.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee emp) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<String>(employeeService.save(emp),HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/saveall")
	public ResponseEntity<String> saveall(@RequestBody List<Employee> emp) throws ClassNotFoundException, SQLException{
		
		
		return new ResponseEntity<String>(employeeService.saveall(emp),HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<ArrayList<Employee>> getall() throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<ArrayList<Employee>>(employeeService.getall(),HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Employee> getbyid(@PathVariable int id) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<Employee>(employeeService.getbyid(id),HttpStatus.OK);
	}
	
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<ArrayList<Employee>> getbyname(@PathVariable String name) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<ArrayList<Employee>>(employeeService.getbyname(name),HttpStatus.OK);
	}
	
	@GetMapping("/getbycname")
	public ResponseEntity<List<Employee>> getbycname(@RequestParam String cname) throws ClassNotFoundException, SQLException{
		
		
		return new ResponseEntity<List<Employee>>(employeeService.getbycname(cname),HttpStatus.OK);
	}
	
	@GetMapping("/logincheck/{email}/{epass}")
	public ResponseEntity<String> logincheck(@PathVariable String email,@PathVariable String epass) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<String>(employeeService.logincheck(email, epass),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable int id) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<String>(employeeService.deletebyid(id),HttpStatus.OK);
	}
	
	@PutMapping("/updatepass/{id}/{pass}")
	public ResponseEntity<String> updatepass(@PathVariable int id,@PathVariable String pass) throws ClassNotFoundException, SQLException{
		
		
		return new ResponseEntity<String>(employeeService.updatepass(id, pass),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String> deleteAll() throws ClassNotFoundException, SQLException{
		
		 employeeService.deleteAll();
		
		return new ResponseEntity<String>("All Records Deleted",HttpStatus.OK);
	}
}
