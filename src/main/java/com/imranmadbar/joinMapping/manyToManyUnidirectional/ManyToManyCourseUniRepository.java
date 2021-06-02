package com.imranmadbar.joinMapping.manyToManyUnidirectional;

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
public class ManyToManyCourseUniRepository {

	@Autowired
	private EntityManager entityManager;

	public List<ManyToManyCourseUniEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToManyCourseUniEntity> criteria = builder.createQuery(ManyToManyCourseUniEntity.class);
		Root<ManyToManyCourseUniEntity> root = criteria.from(ManyToManyCourseUniEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public ManyToManyCourseUniEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToManyCourseUniEntity> criteria = builder.createQuery(ManyToManyCourseUniEntity.class);
		Root<ManyToManyCourseUniEntity> root = criteria.from(ManyToManyCourseUniEntity.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public ManyToManyCourseUniEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManyToManyCourseUniEntity> criteria = builder.createQuery(ManyToManyCourseUniEntity.class);
		Root<ManyToManyCourseUniEntity> root = criteria.from(ManyToManyCourseUniEntity.class);
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
		CriteriaQuery<ManyToManyCourseUniEntity> criteria = builder.createQuery(ManyToManyCourseUniEntity.class);
		Root<ManyToManyCourseUniEntity> root = criteria.from(ManyToManyCourseUniEntity.class);
		criteria.select(root).where(builder.equal(root.get("name"), name));
		try {
			return entityManager.createQuery(criteria).getSingleResult().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	public Boolean save(ManyToManyCourseUniEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(ManyToManyCourseUniEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(ManyToManyCourseUniEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
