package com.jforce.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jforce.dao.IUserRepository;
import com.jforce.model.User;

@Repository
public class UserRepositoryImpl implements IUserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(User user) {
		try {
			entityManager.persist(user);
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(Long userid) {
		int result = entityManager.createQuery("delete from User WHERE id=:id").setParameter("id", userid)
				.executeUpdate();
		return result;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(User user) {
		try {
			User userDb= entityManager.find(User.class, user.getId());
			userDb.setFirstName(user.getFirstName());
			userDb.setLastName(user.getLastName());
			entityManager.merge(userDb);
		} catch (Exception e) {
			System.out.println("HATA : " + e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
	public User getUserById(Long userid) {
		User user = null;
		try {
			user = entityManager.createQuery("from User where id=:id", User.class).setParameter("id", userid)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
		}
		return user;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> getUserList() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}

	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



}
