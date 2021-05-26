package com.yrgo.service;

import java.util.List;

import javax.ejb.Local;

import com.yrgo.domain.ZooStaff;


@Local
public interface ZooManagementServiceLocal {

	
	public void registerStaff(ZooStaff ZooStaff);
	public List<ZooStaff>getAllStaffs();
	public List<ZooStaff>searchByName(String fullName);
	public List<ZooStaff> getStaffByRole(String role);
	public ZooStaff getStaffById(int id);
	public void deleteStaff(int id);
}
