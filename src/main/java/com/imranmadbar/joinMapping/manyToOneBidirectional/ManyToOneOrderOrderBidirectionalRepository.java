package com.imranmadbar.joinMapping.manyToOneBidirectional;

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
public class ManyToOneOrderOrderBidirectionalRepository {

	@Autowired
	private EntityManager entityManager;

	public List<ManyToOneOrderOrderMasterBidirectionalEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToOneOrderOrderMasterBidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterBidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterBidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterBidirectionalEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public ManyToOneOrderOrderMasterBidirectionalEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToOneOrderOrderMasterBidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterBidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterBidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterBidirectionalEntity.class);
		criteria.select(root).where(builder.equal(root.get("orderId"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public ManyToOneOrderOrderMasterBidirectionalEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToOneOrderOrderMasterBidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterBidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterBidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterBidirectionalEntity.class);
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
		CriteriaQuery<ManyToOneOrderOrderMasterBidirectionalEntity> criteria = builder.createQuery(ManyToOneOrderOrderMasterBidirectionalEntity.class);
		Root<ManyToOneOrderOrderMasterBidirectionalEntity> root = criteria.from(ManyToOneOrderOrderMasterBidirectionalEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(ManyToOneOrderOrderMasterBidirectionalEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(ManyToOneOrderOrderMasterBidirectionalEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(ManyToOneOrderOrderMasterBidirectionalEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
