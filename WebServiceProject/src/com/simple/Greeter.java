package com.simple;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.beans.Person;

@WebService(targetNamespace="www.example.org")
public class Greeter {
	
	@WebMethod
	public String sayHello(@WebParam(name="greet_name") String name) {
		return ("Hello, " + name);
	}

	@WebMethod
	@WebResult(name="newperson")
	public Person createPerson(String name) {
		Person p = new Person();
		p.setName(name);
		String time = "" + new java.util.Date();
		p.setCreationDate(time);	
		return p;
	}
	
	@WebMethod
	public String getPersonName(Person person) {
		return person.getName();
	}


}
