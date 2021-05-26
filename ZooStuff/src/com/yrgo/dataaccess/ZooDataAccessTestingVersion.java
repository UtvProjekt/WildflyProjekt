package com.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.yrgo.domain.ZooStaff;

@Stateless
@TestingDao
public class ZooDataAccessTestingVersion implements ZooDataAccess{

	public void insert(ZooStaff newZooStaff) {
		
		
	}

	public List<ZooStaff> findAll() {
		ZooStaff zs1 = new ZooStaff("Eric srg", "Birds", "Cleaner" , 28500);
		ZooStaff zs2 = new ZooStaff(" Göransson","Birds" , "Feeder", 30100);
		List<ZooStaff> zoostaff = new ArrayList<ZooStaff>();
		zoostaff.add(zs1);
		zoostaff.add(zs2);
		return zoostaff;
		
	}

	public List<ZooStaff> findByName(String fullname) {
		return null;
	}

	public List<ZooStaff> getStaffByRole(String role) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public ZooStaff findStaffById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStaff(int id, String jobRole, int salary) {
		// TODO Auto-generated method stub
		
	}

	public void deleteStaff(int id) {
		// TODO Auto-generated method stub
		
	}

}
