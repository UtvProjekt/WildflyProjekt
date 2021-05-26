package com.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import com.yrgo.domain.ZooStaff;

@Local
public interface ZooDataAccess {

	public  void insert(ZooStaff newZooStaff);

	public  List<ZooStaff> findAll();

	public  List<ZooStaff> findByName(String fullname);
	
	public List<ZooStaff> getStaffByRole(String role);
	
	public ZooStaff findStaffById(int id);
	
	public void updateStaff(int id, String jobRole, int salary);
	public void deleteStaff(int id);
}

