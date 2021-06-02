package com.imranmadbar.joinMapping.manyToManyBidirectional;

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
public class ManyToManyCourseBidirRepository {

	@Autowired
	private EntityManager entityManager;

	public List<ManyToManyCourseBidirEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToManyCourseBidirEntity> criteria = builder.createQuery(ManyToManyCourseBidirEntity.class);
		Root<ManyToManyCourseBidirEntity> root = criteria.from(ManyToManyCourseBidirEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public ManyToManyCourseBidirEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToManyCourseBidirEntity> criteria = builder.createQuery(ManyToManyCourseBidirEntity.class);
		Root<ManyToManyCourseBidirEntity> root = criteria.from(ManyToManyCourseBidirEntity.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public ManyToManyCourseBidirEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToManyCourseBidirEntity> criteria = builder.createQuery(ManyToManyCourseBidirEntity.class);
		Root<ManyToManyCourseBidirEntity> root = criteria.from(ManyToManyCourseBidirEntity.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public String findByName(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToManyCourseBidirEntity> criteria = builder.createQuery(ManyToManyCourseBidirEntity.class);
		Root<ManyToManyCourseBidirEntity> root = criteria.from(ManyToManyCourseBidirEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(ManyToManyCourseBidirEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(ManyToManyCourseBidirEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(ManyToManyCourseBidirEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
