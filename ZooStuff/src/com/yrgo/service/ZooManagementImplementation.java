package com.yrgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.yrgo.dataaccess.ProductionDao;
import com.yrgo.dataaccess.ZooDataAccess;
import com.yrgo.domain.ZooStaff;

import javax.inject.Inject;

//Class that calls the dataaccess classes where the data is created/removed/updated/gathered from/to the database
@Stateless
public class ZooManagementImplementation implements ZooManagementService, ZooManagementServiceLocal{

	@Inject
	@ProductionDao
	private ZooDataAccess zda;
	
	public void registerStaff(ZooStaff newStaff) {
		zda.insert(newStaff);
	}
	
	
	public List<ZooStaff> searchByName(String fullName){
		return zda.findByName(fullName);
	}
	
	
	public List<ZooStaff> getAllStaffs(){
		return zda.findAll();
	}

	public List<ZooStaff> getStaffByRole(String role){
		return zda.getStaffByRole(role);
	}
	
	
	public ZooStaff getStaffById(int id) {
		return zda.findStaffById(id);
	}
	
	public void deleteStaff(int id) {
		zda.deleteStaff(id);
			
	}
	
}
