package com.ty_many_to_one_uni_bank_dao;

import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_many_to_one_uni_bank_dto.Bank;
import com.ty_many_to_one_uni_bank_dto.Branch;

public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return  entityManagerFactory.createEntityManager();
	}
	
	public void saveBranch(List<Branch> branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for(Branch b:branch ) {
			entityTransaction.begin();
			entityManager.persist(b);
			entityTransaction.commit();
		}
		
	}
	
	public void updateBranch(List<Branch> branch ,int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch recievedbranch = entityManager.find(Branch.class, id);
		if(recievedbranch != null) {
			entityTransaction.begin();
			branch.set(id, recievedbranch);
			entityManager.merge(branch);
			entityTransaction.commit();
		}else {
			System.out.println("Branch Does Not Exist");
		}
		
	}
	public void deleteBranch(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, id);
		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();
	}
	
	public void getAllBranch() {
		EntityManager entityManager = getEntityManager();
		Query query  = entityManager.createQuery("select b from Branch b");
		List< Branch> list = query.getResultList();
		System.out.println(list);
		
}
}
