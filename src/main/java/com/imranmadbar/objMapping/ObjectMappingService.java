package com.imranmadbar.objMapping;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectMappingService {

	@Autowired
	private ObjectMappingRepository repository;
	
	
	public String reqReqPropMap(String reqSr) {
		return repository.reqReqPropMap(reqSr);
	}
	
	public String reqBodyPropMap(String reqSr) {
		return repository.reqBodyPropMap(reqSr);
	}
	
	public String reqBodyEntityMap(String reqSr) {
		return repository.reqBodyEntityMap(reqSr);
	}
	
	public String reqBodyEntityArrMap(String reqSr) {
		return repository.reqBodyEntityArrMap(reqSr);
	}


	

}
