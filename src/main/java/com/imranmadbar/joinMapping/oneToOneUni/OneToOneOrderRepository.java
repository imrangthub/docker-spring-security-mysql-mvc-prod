package com.imranmadbar.joinMapping.oneToOneUni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OneToOneOrderRepository {

	@Autowired
	private EntityManager entityManager;

	public List<OneToOneOrderMasterEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToOneOrderMasterEntity> criteria = builder.createQuery(OneToOneOrderMasterEntity.class);
		Root<OneToOneOrderMasterEntity> root = criteria.from(OneToOneOrderMasterEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public OneToOneOrderMasterEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToOneOrderMasterEntity> criteria = builder.createQuery(OneToOneOrderMasterEntity.class);
		Root<OneToOneOrderMasterEntity> root = criteria.from(OneToOneOrderMasterEntity.class);
		criteria.select(root).where(builder.equal(root.get("orderId"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public OneToOneOrderMasterEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToOneOrderMasterEntity> criteria = builder.createQuery(OneToOneOrderMasterEntity.class);
		Root<OneToOneOrderMasterEntity> root = criteria.from(OneToOneOrderMasterEntity.class);
		criteria.select(root).where(builder.equal(root.get("orderId"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public String findByName(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToOneOrderMasterEntity> criteria = builder.createQuery(OneToOneOrderMasterEntity.class);
		Root<OneToOneOrderMasterEntity> root = criteria.from(OneToOneOrderMasterEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(OneToOneOrderMasterEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(OneToOneOrderMasterEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(OneToOneOrderMasterEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
