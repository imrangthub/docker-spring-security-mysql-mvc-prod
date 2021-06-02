package com.imranmadbar.joinMapping.manyToOneUnidirectional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManyToOneOrderUnidirectionalConteoller {

	@Autowired
	private ManyToOneOrderOrderUnidirectionalService oneToManyOrderService;
	
	@GetMapping("/many-to-one-order-uni")
	public String testMsg() {
		return "Welcome to One to many Mappint !";
	}

	@GetMapping("/many-to-one-order-uni/list")
	public List<ManyToOneOrderOrderMasterUnidirectionalEntity> list(Model model) {
		return oneToManyOrderService.list();
	}

	@PostMapping("/many-to-one-order-uni/save")
	public String orderSave(@RequestBody ManyToOneOrderOrderMasterUnidirectionalEntity saveObj) {
		if (saveObj == null) {
			return "No data found for save.";
		}
		return oneToManyOrderService.orderSave(saveObj);
	}

	@GetMapping("/many-to-one-order-uni/view/{id}")
	public String findById(@PathVariable("id") long id) {
		ManyToOneOrderOrderMasterUnidirectionalEntity findObj = null;
		try {
			findObj = oneToManyOrderService.findById(id);
			return findObj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error: Found !";
	}

	@PostMapping("/many-to-one-order-uni/update")
	public String orderUpdate(@RequestBody ManyToOneOrderOrderMasterUnidirectionalEntity updateObj) {
		if (updateObj != null) {
			return oneToManyOrderService.orderUpdate(updateObj);
		}
		return "Update failed, No date found !";
	}

	@GetMapping("/many-to-one-order-uni/delete/{id}")
	public String orderDelete(@PathVariable("id") Long id) {
		return oneToManyOrderService.orderDelete(id);
	}

}

