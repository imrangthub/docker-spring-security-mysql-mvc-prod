package com.imranmadbar.joinMapping.oneToManyUnidirectional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToManyUnidirectionalConteoller {

	@Autowired
	private OneToManyOrderUnidirectionalService oneToManyOrderService;
	
	@GetMapping("/one-to-many-order-uni")
	public String testMsg() {
		return "Welcome to One to many Mappint !";
	}

	@GetMapping("/one-to-many-order-uni/list")
	public List<OneToManyOrderMasterUnidirectionalEntity> list(Model model) {
		return oneToManyOrderService.list();
	}

	@PostMapping("/one-to-many-order-uni/save")
	public String orderSave(@RequestBody OneToManyOrderMasterUnidirectionalEntity saveObj) {
		if (saveObj == null) {
			return "No data found for save.";
		}
		return oneToManyOrderService.orderSave(saveObj);
	}

	@GetMapping("/one-to-many-order-uni/view/{id}")
	public String findById(@PathVariable("id") long id) {
		OneToManyOrderMasterUnidirectionalEntity findObj = null;
		try {
			findObj = oneToManyOrderService.findById(id);
			return findObj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error: Found !";
	}

	@PostMapping("/one-to-many-order-uni/update")
	public String orderUpdate(@RequestBody OneToManyOrderMasterUnidirectionalEntity updateObj) {
		if (updateObj != null) {
			return oneToManyOrderService.orderUpdate(updateObj);
		}
		return "Update failed, No date found !";
	}

	@GetMapping("/one-to-many-order-uni/delete/{id}")
	public String orderDelete(@PathVariable("id") Long id) {
		return oneToManyOrderService.orderDelete(id);
	}

}

