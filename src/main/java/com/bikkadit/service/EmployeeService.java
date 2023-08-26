package com.bikkadit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bikkadit.model.Employee;

public interface EmployeeService {
	
	public String save(Employee emp) throws ClassNotFoundException, SQLException;
	
	public String saveall(List<Employee> emp) throws ClassNotFoundException, SQLException;
	
	public ArrayList<Employee> getall() throws ClassNotFoundException, SQLException;
	
	public Employee getbyid(int id) throws ClassNotFoundException, SQLException;
	
	public ArrayList<Employee> getbyname(String name) throws ClassNotFoundException, SQLException;
	
	public List<Employee> getbycname(String cname) throws ClassNotFoundException, SQLException;
	
	public String logincheck(String email,String epass) throws ClassNotFoundException, SQLException;
	
	public String deletebyid(int id) throws ClassNotFoundException, SQLException;
	
	public String updatepass(int id,String pass) throws ClassNotFoundException, SQLException;
	
	public void deleteAll() throws ClassNotFoundException, SQLException;

}
