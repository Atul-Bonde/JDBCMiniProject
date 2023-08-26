package com.bikkadit.query;

import org.springframework.stereotype.Component;

@Component
public class Query {
	
	
	public String save="insert into employee values (?,?,?,?,?,?,?,?,?)";
	
	public String findall="select * from employee";
	
	public String findbyid="select * from employee where eid=?";
	
	public String findbyname="select * from employee where ename=?";
	
	public String findbycompanayname="select * from employee where ecompanyname=?";
	
	public String logincheck="select * from employee where email=? and epass=?";
	
	public String deletebyid="delete from employee where eid=?";
	
	public String updatepass="update employee set epass=? where eid=?";
	
	public String deleteall="delete from employee";

}
