package com.bikkadit.service.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.exceptionhandling.UserNotFound;
import com.bikkadit.model.Employee;
import com.bikkadit.repository.EmployeeRepository;
import com.bikkadit.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String save(Employee emp) throws ClassNotFoundException, SQLException {
		
		boolean save = employeeRepository.save(emp);
		
		if(save) {
			
			return "Record is not Saved";
		}
		else {
			
			return "Record is Saved Successfully";
			
		}
		
		
	}

	@Override
	public String saveall(List<Employee> emp) throws ClassNotFoundException, SQLException {
		
		           boolean saveall = employeeRepository.saveall(emp);
		           
		           if(saveall) {
		        	   
		        	   return "All Record not saved";
		           }
		           else {
		        	   return "All Record Saved Successfully";
		           }
		
	}

	@Override
	public ArrayList<Employee> getall() throws ClassNotFoundException, SQLException {
		
		return employeeRepository.getall();
	}

	@Override
	public Employee getbyid(int id) throws ClassNotFoundException, SQLException {
		
	 Employee findbyid = employeeRepository.findbyid(id);
	 
	 if(findbyid.getEid()==0) {
		 
		 throw new UserNotFound("No such User Found for id "+ id);
	 }
	 else {
		 
		 return findbyid;
	 }
	}

	@Override
	public ArrayList<Employee> getbyname(String name) throws ClassNotFoundException, SQLException {

            ArrayList<Employee> findbyname = employeeRepository.findbyname(name);
            
            if(findbyname.isEmpty()) {
            	
            	throw new UserNotFound("No such User Found for Name : "+name);
            }    
            	
            	return findbyname;
		
	}

	@Override
	public List<Employee> getbycname(String cname) throws ClassNotFoundException, SQLException {

		List<Employee> findbycompany = employeeRepository.findbycompany(cname);
		
		if(findbycompany.isEmpty()) {
			
			throw new UserNotFound("No Any Employee In List from : "+cname);
		}

		            
		return findbycompany;
	}

	@Override
	public String logincheck(String email, String epass) throws ClassNotFoundException, SQLException {
		
		Employee checklogin = employeeRepository.checklogin(email, epass);
		
		if(checklogin.getEemail()==null) {
			
			return "Please Enter a Valid Email or Password";
		}
		else {
              		
		return "Login Successfully";
		
		}
	}

	@Override
	public String deletebyid(int id) throws ClassNotFoundException, SQLException {
		
		int deletebyid = employeeRepository.deletebyid(id);
		
		if(deletebyid==0) {
			
			return "Employeee Details not Deleted..Please Enter a Valid Id";
		}
		else {
			return "Employee Details Deleted successfully";
		}
		     
		
	}

	@Override
	public String updatepass(int id, String pass) throws ClassNotFoundException, SQLException {
		
		Employee findbyid = employeeRepository.findbyid(id);
		
		if(findbyid.getEname()!=null) {
			
			 employeeRepository.updatepass(id, pass);
			 
			 return "Password Updated Successfully";
		}
		
		else {
			
			return "Password is not updated. please Enter a Valid Information";
		}
	}

	@Override
	public void deleteAll() throws ClassNotFoundException, SQLException {
		
		        employeeRepository.deleteAll();
		
	}

}
