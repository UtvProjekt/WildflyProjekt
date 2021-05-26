package com.yrgo.client;




import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.yrgo.domain.ZooStaff;
import com.yrgo.service.ZooManagementService;



public class Main {

	public static void main(String[] args) throws NamingException {
		System.out.println("h");
		Properties jndiProperties = new Properties();
		System.out.println("s");
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context",true);
		
		Context jndi = new InitialContext(jndiProperties);
		
		ZooManagementService service = (ZooManagementService)jndi.lookup("zoo/ZooManagementImplementation!com.yrgo.service.ZooManagementService");
		
		//Adds a few staffs to the database
		
		ZooStaff emp1 = new ZooStaff("Andreas","cats","cleaner",2700);
		ZooStaff emp2 = new ZooStaff("Rikard","fish","feeder",1800);
		ZooStaff emp3 = new ZooStaff("Ronald","apes","cleaner",2900);
		ZooStaff emp4 = new ZooStaff("Eric","fish","vet",2000);
		
		service.registerStaff(emp1);
		service.registerStaff(emp2);
		service.registerStaff(emp3);
		service.registerStaff(emp4);
		
		
		
		
	
		
	}
	
}
