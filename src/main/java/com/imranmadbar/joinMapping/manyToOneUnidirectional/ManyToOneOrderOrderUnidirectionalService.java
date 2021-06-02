package com.imranmadbar.joinMapping.manyToOneUnidirectional;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManyToOneOrderOrderUnidirectionalService {

	@Autowired
	private ManyToOneOrderOrderUnidirectionalRepository repository;

	public List<ManyToOneOrderOrderMasterUnidirectionalEntity> list() {
		return repository.list();
	}

	public ManyToOneOrderOrderMasterUnidirectionalEntity findById(Long id) {
		return repository.findById(id);
	}

	public String findByName(String userName) {
		return repository.findByName(userName);
	}

	public String saveOrUpdate(ManyToOneOrderOrderMasterUnidirectionalEntity obj) {
		try {
			if (obj.getOrderId() == null) {
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

	public String orderSave(ManyToOneOrderOrderMasterUnidirectionalEntity obj) {
		try {
			repository.save(obj);
			return "Order save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "save Failed !";
	}

	public String orderUpdate(ManyToOneOrderOrderMasterUnidirectionalEntity OrderObj) {
		ManyToOneOrderOrderMasterUnidirectionalEntity obj = null;
		obj = repository.findByIdObj(OrderObj.getOrderId());
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
		ManyToOneOrderOrderMasterUnidirectionalEntity obj = null;
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
