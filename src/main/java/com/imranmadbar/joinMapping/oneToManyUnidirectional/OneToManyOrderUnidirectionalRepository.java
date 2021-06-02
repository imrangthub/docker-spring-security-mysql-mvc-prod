package com.imranmadbar.joinMapping.oneToManyUnidirectional;

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
public class OneToManyOrderUnidirectionalRepository {

	@Autowired
	private EntityManager entityManager;

	public List<OneToManyOrderMasterUnidirectionalEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToManyOrderMasterUnidirectionalEntity> criteria = builder.createQuery(OneToManyOrderMasterUnidirectionalEntity.class);
		Root<OneToManyOrderMasterUnidirectionalEntity> root = criteria.from(OneToManyOrderMasterUnidirectionalEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public OneToManyOrderMasterUnidirectionalEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToManyOrderMasterUnidirectionalEntity> criteria = builder.createQuery(OneToManyOrderMasterUnidirectionalEntity.class);
		Root<OneToManyOrderMasterUnidirectionalEntity> root = criteria.from(OneToManyOrderMasterUnidirectionalEntity.class);
		criteria.select(root).where(builder.equal(root.get("orderId"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public OneToManyOrderMasterUnidirectionalEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OneToManyOrderMasterUnidirectionalEntity> criteria = builder.createQuery(OneToManyOrderMasterUnidirectionalEntity.class);
		Root<OneToManyOrderMasterUnidirectionalEntity> root = criteria.from(OneToManyOrderMasterUnidirectionalEntity.class);
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
		CriteriaQuery<OneToManyOrderMasterUnidirectionalEntity> criteria = builder.createQuery(OneToManyOrderMasterUnidirectionalEntity.class);
		Root<OneToManyOrderMasterUnidirectionalEntity> root = criteria.from(OneToManyOrderMasterUnidirectionalEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(OneToManyOrderMasterUnidirectionalEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(OneToManyOrderMasterUnidirectionalEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(OneToManyOrderMasterUnidirectionalEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
