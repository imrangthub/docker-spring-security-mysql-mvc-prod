package com.imranmadbar.joinMapping.manyToManyBidirectional;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManyToManyCourseBidirService {

	@Autowired
	private ManyToManyCourseBidirRepository repository;

	public List<ManyToManyCourseBidirEntity> list() {
		return repository.list();
	}

	public ManyToManyCourseBidirEntity findById(Long id) {
		return repository.findById(id);
	}

	public String findByName(String userName) {
		return repository.findByName(userName);
	}

	public String saveOrUpdate(ManyToManyCourseBidirEntity obj) {
		try {
			if (obj.getId() == null) {
				repository.save(obj);
				return "Order save successfully done !";
			}
			repository.update(obj);
			return "Order update successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}

	public String orderSave(ManyToManyCourseBidirEntity obj) {
		try {
			repository.save(obj);
			return "Order save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "save Failed !";
	}

	public String orderUpdate(ManyToManyCourseBidirEntity OrderObj) {
		ManyToManyCourseBidirEntity obj = null;
		obj = repository.findByIdObj(OrderObj.getId());
		if (obj == null) {
			return "Data not found !";
		}
		try {
			repository.update(OrderObj);
			return "Order update successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}

	public String orderDelete(Long id) {
		ManyToManyCourseBidirEntity obj = null;
		obj = repository.findByIdObj(id);
		if (obj == null) {
			return "Data not found !";
		}
		try {
			repository.delete(obj);
			return "Order delete successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "Delete failed !";
	}

}
