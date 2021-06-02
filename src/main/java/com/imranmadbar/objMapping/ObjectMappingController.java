package com.imranmadbar.objMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.joinMapping.manyToManyBidirectional.ManyToManyCourseBidirEntity;
import com.imranmadbar.joinMapping.manyToManyBidirectional.ManyToManyCourseBidirService;


@RestController
public class ObjectMappingController {
	
	@Autowired
	private ObjectMappingService objectMappingService;
	
	@GetMapping("/object-mapping")
	public String testMsg() {
		return "Welcome to One to object mapping !";
	}

	@GetMapping("/object-mapping/reqpropmap")
	public String reqReqPropMap(@RequestParam("orderId") String orderId) {
		return objectMappingService.reqReqPropMap(orderId);
	}

	@PostMapping("/object-mapping/resbodypropmap")
	public String reqBodyPropMap(@RequestBody String reqStr) {
		if (reqStr == null) {
			return "No data found for save.";
		}
		return objectMappingService.reqBodyPropMap(reqStr);
	}
	
	
	@PostMapping("/object-mapping/resbodyentitymap")
	public String reqBodyEntityMap(@RequestBody String reqStr) {
		return objectMappingService.reqBodyEntityMap(reqStr);
	}
	
	@PostMapping("/object-mapping/resbodyentityarrmap")
	public String reqBodyEntityArrMap(@RequestBody String reqStr) {
		return objectMappingService.reqBodyEntityArrMap(reqStr);
	}

}
