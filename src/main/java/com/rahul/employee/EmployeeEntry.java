package com.rahul.employee;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeEntry {

	public static void main(String[] args) {
		
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
	
		Employee e1=new Employee(111,"AAA",50000, new Laptop("L111"));
		e1.getProjects().add(new Project("p111"));
		e1.getProjects().add(new Project("p112"));
		e1.getProjects().add(new Project("p113"));
		

		
		Employee e2 = new Employee(112, "BBB", 60000, new Laptop("L112"));

		e2.getProjects().add(new Project("p113"));
		e2.getProjects().add(new Project("p114"));
		e2.getProjects().add(new Project("p115"));
		Employee e3 = new Employee(113, "CCC", 70000, new Laptop("L113"));

		e3.getProjects().add(new Project("p111"));
		e3.getProjects().add(new Project("p114"));
		e3.getProjects().add(new Project("p115"));
		 

		
		Transaction tr=session.beginTransaction();
		session.save(e1); 
		session.save(e2);
		session.save(e3); 
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");

	}

}