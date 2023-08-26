package com.bikkadit.model;

public class Employee {
	
	
	private int eid;
	
	private String ename;
	
	private int eage;
	
	private String erole;
	
	private String eaddress;
	
	private double esalary;
	
	private String ecompanyname;
	
	private String eemail;
	
	private String epass;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEage() {
		return eage;
	}

	public void setEage(int eage) {
		this.eage = eage;
	}

	public String getErole() {
		return erole;
	}

	public void setErole(String erole) {
		this.erole = erole;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	public String getEcompanyname() {
		return ecompanyname;
	}

	public void setEcompanyname(String ecompanyname) {
		this.ecompanyname = ecompanyname;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEpass() {
		return epass;
	}

	public void setEpass(String epass) {
		this.epass = epass;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", erole=" + erole + ", eaddress="
				+ eaddress + ", esalary=" + esalary + ", ecompanyname=" + ecompanyname + ", eemail=" + eemail
				+ ", epass=" + epass + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, int eage, String erole, String eaddress, double esalary, String ecompanyname,
			String eemail, String epass) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eage = eage;
		this.erole = erole;
		this.eaddress = eaddress;
		this.esalary = esalary;
		this.ecompanyname = ecompanyname;
		this.eemail = eemail;
		this.epass = epass;
	}
	
	

	
	
	
	

}
