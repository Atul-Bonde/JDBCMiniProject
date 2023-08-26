package com.bikkadit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bikkadit.configuration.JDBCConfi;
import com.bikkadit.model.Employee;
import com.bikkadit.query.Query;

@Repository
public class EmployeeRepository {
	
	
	
	@Autowired
	private Connection connection;
	
	@Autowired
	private Query query;
	
	
	public boolean save(Employee emp) throws ClassNotFoundException, SQLException {
		
		
		
		String save = query.save;
		
		PreparedStatement ps = connection.prepareStatement(save);
		
		ps.setInt(1, emp.getEid());
		ps.setString(2, emp.getEname());
		ps.setInt(3, emp.getEage());
		ps.setString(4, emp.getErole());
		ps.setString(5, emp.getEaddress());
		ps.setDouble(6, emp.getEsalary());
		ps.setString(7, emp.getEcompanyname());
		ps.setString(8, emp.getEemail());
		ps.setString(9, emp.getEpass());
		
		
		boolean execute = ps.execute();
		
//		connection.close();
		
		return execute;
		
		
	}
	
	
	public boolean saveall(List<Employee> emp) throws SQLException {
		
		String save = query.save;
		
		boolean execute=true;
		
		for(Employee e :emp) {
			
			PreparedStatement ps = connection.prepareStatement(save);
			
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getEname());
			ps.setInt(3, e.getEage());
			ps.setString(4, e.getErole());
			ps.setString(5, e.getEaddress());
			ps.setDouble(6, e.getEsalary());
			ps.setString(7, e.getEcompanyname());
			ps.setString(8, e.getEemail());
			ps.setString(9, e.getEpass());
			
			 execute = ps.execute();
			
			
		}
		
//		connection.close();
		
		return execute;
	}
	
	
	public ArrayList<Employee> getall() throws SQLException{
		
		
		ArrayList<Employee> al=new ArrayList<>();
		
	    String findall = query.findall;
	    
	    
	    Statement st = connection.createStatement();
	    
	    ResultSet rs = st.executeQuery(findall);
	    
	    Employee e=new Employee();
	    
	    while(rs.next()) {
	    	
	    	
	    e=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9));
	    
	    al.add(e);
	    	
	    }
		
//		connection.close();
		
		return al;
		
	}
	
	
	
	public Employee findbyid(int id) throws SQLException {
		
		
		String findbyid = query.findbyid;
		
		PreparedStatement ps = connection.prepareStatement(findbyid);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		Employee e=new Employee();
		
		while(rs.next()) {
			
			e=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9));
			
		}
		
//		connection.close();
		
		return e;
		
		
	}
	
	
	public ArrayList<Employee> findbyname(String name) throws SQLException{
		
		ArrayList<Employee> al=new ArrayList<>();
		
		String findbyname = query.findbyname;
		
		PreparedStatement ps = connection.prepareStatement(findbyname);
		
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		
		Employee e=new Employee();
		
		while(rs.next()) {
			
			e=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9));
			
			al.add(e);
		}
		
//		connection.close();
		
		return al;
		
	}
	
	public List<Employee> findbycompany(String cname) throws SQLException{
		
		
		List<Employee> list=new ArrayList<>();
		
		String findbycompanayname = query.findbycompanayname;
		
		PreparedStatement ps = connection.prepareStatement(findbycompanayname);
		
		ps.setString(1, cname);
		
		ResultSet rs = ps.executeQuery();
		
		Employee e=new Employee();
		
		while(rs.next()) {
			
			e=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9));
			
			list.add(e);
			
		}
		
		return list;
		
	}
	
	public Employee  checklogin(String email,String epass) throws SQLException {
		
		String logincheck = query.logincheck;
		
		PreparedStatement ps = connection.prepareStatement(logincheck);
		
		ps.setString(1, email);
		ps.setString(2, epass);
		
		ResultSet rs = ps.executeQuery();
		
		Employee e=new Employee();
		
		while(rs.next()) {
			
			e=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9));
			
		}
		
		return e;
		
	}
	
	public int deletebyid(int id) throws SQLException {
		
		String deletebyid = query.deletebyid;
		
		PreparedStatement ps = connection.prepareStatement(deletebyid);
		
		ps.setInt(1, id);
		
		int executeUpdate = ps.executeUpdate();
		
		return executeUpdate;
		
	}
	
	public int updatepass(int id,String pass) throws SQLException {
		
		String updatepass = query.updatepass;
		
		PreparedStatement ps = connection.prepareStatement(updatepass);
		
		ps.setString(1, pass);
		ps.setInt(2, id);
		
		int executeUpdate = ps.executeUpdate();
		
		return executeUpdate;
	}
	
	
	public void deleteAll() throws SQLException {
		
		String deleteall = query.deleteall;
		
		Statement st = connection.createStatement();
		
		st.executeUpdate(deleteall);
	}
	

}
