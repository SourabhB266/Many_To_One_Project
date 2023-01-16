package com.ty_many_to_one_uni_bank_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.ty_many_to_one_uni_bank_dto.Bank;

public class BankDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return  entityManagerFactory.createEntityManager();
	}
	
	public void saveBank(Bank bank) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
			entityTransaction.begin();
			entityManager.merge(bank);
			entityTransaction.commit();
			System.out.println("Inserted..");
		
		
	}
	public void updateBank(int id, Bank bank) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank recievedBank = entityManager.find(Bank.class, id);
		if(recievedBank != null) {
			entityTransaction.begin();
			bank.setId(id);
			entityManager.merge(bank);
			entityTransaction.commit();
		}else {
			System.out.println("Bank Does Not Exist");
		}
		
	}
	public void deleteBank(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank bank = entityManager.find(Bank.class, id);
		entityTransaction.begin();
		entityManager.remove(bank);
		entityTransaction.commit();
	}
	
	public void getAllBank(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank bank = entityManager.find(Bank.class, id);
		System.out.println(bank);
		
	}
	
}
