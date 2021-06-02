package com.imranmadbar.joinMapping.oneToOneBiDir;

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
public class OneToOneBiDirOrderRepository {

	@Autowired
	private EntityManager entityManager;

	public List<OneToOneBiDirOrderMasterEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToOneBiDirOrderMasterEntity> criteria = builder.createQuery(OneToOneBiDirOrderMasterEntity.class);
		Root<OneToOneBiDirOrderMasterEntity> root = criteria.from(OneToOneBiDirOrderMasterEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public OneToOneBiDirOrderMasterEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToOneBiDirOrderMasterEntity> criteria = builder.createQuery(OneToOneBiDirOrderMasterEntity.class);
		Root<OneToOneBiDirOrderMasterEntity> root = criteria.from(OneToOneBiDirOrderMasterEntity.class);
		criteria.select(root).where(builder.equal(root.get("orderId"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public OneToOneBiDirOrderMasterEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToOneBiDirOrderMasterEntity> criteria = builder.createQuery(OneToOneBiDirOrderMasterEntity.class);
		Root<OneToOneBiDirOrderMasterEntity> root = criteria.from(OneToOneBiDirOrderMasterEntity.class);
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
		CriteriaQuery<OneToOneBiDirOrderMasterEntity> criteria = builder.createQuery(OneToOneBiDirOrderMasterEntity.class);
		Root<OneToOneBiDirOrderMasterEntity> root = criteria.from(OneToOneBiDirOrderMasterEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(OneToOneBiDirOrderMasterEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(OneToOneBiDirOrderMasterEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(OneToOneBiDirOrderMasterEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
