package com.imranmadbar.joinMapping.manyToOneBidirectional;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManyToOneOrderOrderBidirectionalService {

	@Autowired
	private ManyToOneOrderOrderBidirectionalRepository repository;

	public List<ManyToOneOrderOrderMasterBidirectionalEntity> list() {
		return repository.list();
	}

	public ManyToOneOrderOrderMasterBidirectionalEntity findById(Long id) {
		return repository.findById(id);
	}

	public String findByName(String userName) {
		return repository.findByName(userName);
	}

	public String saveOrUpdate(ManyToOneOrderOrderMasterBidirectionalEntity obj) {
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

	public String orderSave(ManyToOneOrderOrderMasterBidirectionalEntity obj) {
		try {
			repository.save(obj);
			return "Order save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "save Failed !";
	}

	public String orderUpdate(ManyToOneOrderOrderMasterBidirectionalEntity OrderObj) {
		ManyToOneOrderOrderMasterBidirectionalEntity obj = null;
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
		ManyToOneOrderOrderMasterBidirectionalEntity obj = null;
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
