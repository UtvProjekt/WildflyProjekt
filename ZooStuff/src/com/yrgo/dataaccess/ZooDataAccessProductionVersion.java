package com.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yrgo.domain.ZooStaff;

//Makes this the default dataaccess class thats called
@Stateless
@Default
@ProductionDao
public class ZooDataAccessProductionVersion implements ZooDataAccess{

	@PersistenceContext
	private EntityManager em;
	
	public void insert(ZooStaff newZooStaff) {
		em.persist(newZooStaff);
	}

	//Method that creates a query that returns all the staffs from the zoo
	public List<ZooStaff> findAll() {
		Query q = em.createQuery("select zoostaff from ZooStaff zoostaff");
		List<ZooStaff> zoostaffs = q.getResultList();
		return zoostaffs;
		
	}
	
	//Method that creates a query that returns a single staff depending on given id
	public ZooStaff findStaffById(int id) {
		Query q = em.createQuery("select zoostaff from ZooStaff zoostaff where zoostaff.id = :id");
		q.setParameter("id", id);
		return (ZooStaff) q.getSingleResult();
	}

	//Method that creates a query that returns one or multiple staffs depending on name
	public List<ZooStaff> findByName(String fullName) {
		Query q = em.createQuery("select zoostaff from ZooStaff zoostaff where zoostaff.fullName = :fullName");
		q.setParameter("fullName", fullName);
		return q.getResultList();
	}

	//Method that creates a query that returns a list of staffs with a certain role
	public List<ZooStaff> getStaffByRole(String role){
		Query q = em.createQuery("select zoostaff from ZooStaff zoostaff where zoostaff.role = :role");
		q.setParameter("role", role);
		return q.getResultList();
	}
	
	
	//Method that deletes a staff by calling the findStaffById method
	public void deleteStaff(int id){
		ZooStaff e = findStaffById(id);
		em.remove(e);
	}
	
	
	//Method that updates a staff by calling the findStaffById method
	public void updateStaff(int id, String jobRole, int salary) {
		ZooStaff e = findStaffById(id);
		e.setRole(jobRole);
		e.setSalary(salary);
	}

}
