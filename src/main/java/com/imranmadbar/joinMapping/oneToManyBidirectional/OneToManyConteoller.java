package com.imranmadbar.joinMapping.oneToManyBidirectional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToManyConteoller {

	@Autowired
	private OneToManyOrderService oneToManyOrderService;
	
	@GetMapping("/one-to-many-order")
	public String testMsg() {
		return "Welcome to One to many Mappint !";
	}

	@GetMapping("/one-to-many-order/list")
	public List<OneToManyOrderMasterEntity> list(Model model) {
		return oneToManyOrderService.list();
	}

	@PostMapping("/one-to-many-order/save")
	public String orderSave(@RequestBody OneToManyOrderMasterEntity saveObj) {
		if (saveObj == null) {
			return "No data found for save.";
		}
		return oneToManyOrderService.orderSave(saveObj);
	}

	@GetMapping("/one-to-many-order/view/{id}")
	public String findById(@PathVariable("id") long id) {
		OneToManyOrderMasterEntity findObj = null;
		try {
			findObj = oneToManyOrderService.findById(id);
			return findObj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error: Found !";
	}

	@PostMapping("/one-to-many-order/update")
	public String orderUpdate(@RequestBody OneToManyOrderMasterEntity updateObj) {
		if (updateObj != null) {
			return oneToManyOrderService.orderUpdate(updateObj);
		}
		return "Update failed, No date found !";
	}

	@GetMapping("/one-to-many-order/delete/{id}")
	public String orderDelete(@PathVariable("id") Long id) {
		return oneToManyOrderService.orderDelete(id);
	}

}

