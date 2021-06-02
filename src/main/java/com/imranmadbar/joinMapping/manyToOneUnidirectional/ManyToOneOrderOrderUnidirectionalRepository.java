package com.imranmadbar.joinMapping.manyToOneUnidirectional;

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
public class ManyToOneOrderOrderUnidirectionalRepository {

	@Autowired
	private EntityManager entityManager;

	public List<ManyToOneOrderOrderMasterUnidirectionalEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToOneOrderOrderMasterUnidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterUnidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public ManyToOneOrderOrderMasterUnidirectionalEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToOneOrderOrderMasterUnidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterUnidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
		criteria.select(root).where(builder.equal(root.get("orderId"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public ManyToOneOrderOrderMasterUnidirectionalEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToOneOrderOrderMasterUnidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterUnidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
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
		CriteriaQuery<ManyToOneOrderOrderMasterUnidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterUnidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterUnidirectionalEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(ManyToOneOrderOrderMasterUnidirectionalEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(ManyToOneOrderOrderMasterUnidirectionalEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(ManyToOneOrderOrderMasterUnidirectionalEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
