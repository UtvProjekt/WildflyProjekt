package com.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.yrgo.domain.ZooStaff;
import com.yrgo.service.ZooManagementService;
import com.yrgo.service.ZooManagementServiceLocal;

@Stateless
@Path("/zoostaffs")
public class ZooResource {
	@Inject
	private ZooManagementServiceLocal service;
	
	//Calls a service method that gets a staff depending on id where the id is the parameter of the client target link 
	@GET
	@Path("{id}")
	@Produces("application/JSON")
	public ZooStaff getStaffById(@PathParam("id")int id) {
		return service.getStaffById(id);
	}
	
	//Calls a service method that gets all the staffs when no extra path or query is given
	@GET
	@Produces("application/JSON")
	public List<ZooStaff> getAllStaffs(){
		return service.getAllStaffs();
	}
	
	//Calls a service method that gets all the staffs of a certain role when /query?id=(name of role) is given
	@GET
	@Produces("application/JSON")
	@Path("/query")
	public List<ZooStaff> getStaffByRole(@QueryParam("role")String role) {
		return service.getStaffByRole(role);
	}
	
	//Calls a service method that creates a staff
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public ZooStaff createStaff(ZooStaff staff) {
		service.registerStaff(staff);
		return staff;
	}
	
	//Calls a service method that deletes a staff
	@DELETE
	@Path("{id}")
	public void deleteStaff(@PathParam("id") int id) {
		service.deleteStaff(id);
	}
}


