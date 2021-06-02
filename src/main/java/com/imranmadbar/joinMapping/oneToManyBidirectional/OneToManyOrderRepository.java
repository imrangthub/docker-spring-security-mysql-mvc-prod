package com.imranmadbar.joinMapping.oneToManyBidirectional;

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
public class OneToManyOrderRepository {

	@Autowired
	private EntityManager entityManager;

	public List<OneToManyOrderMasterEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToManyOrderMasterEntity> criteria = builder.createQuery(OneToManyOrderMasterEntity.class);
		Root<OneToManyOrderMasterEntity> root = criteria.from(OneToManyOrderMasterEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public OneToManyOrderMasterEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToManyOrderMasterEntity> criteria = builder.createQuery(OneToManyOrderMasterEntity.class);
		Root<OneToManyOrderMasterEntity> root = criteria.from(OneToManyOrderMasterEntity.class);
		criteria.select(root).where(builder.equal(root.get("orderId"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public OneToManyOrderMasterEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToManyOrderMasterEntity> criteria = builder.createQuery(OneToManyOrderMasterEntity.class);
		Root<OneToManyOrderMasterEntity> root = criteria.from(OneToManyOrderMasterEntity.class);
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
		CriteriaQuery<OneToManyOrderMasterEntity> criteria = builder.createQuery(OneToManyOrderMasterEntity.class);
		Root<OneToManyOrderMasterEntity> root = criteria.from(OneToManyOrderMasterEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(OneToManyOrderMasterEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(OneToManyOrderMasterEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(OneToManyOrderMasterEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
