package com.imranmadbar.joinMapping.manyToOneBidirectional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManyToOneOrderBidirectionalConteoller {

	@Autowired
	private ManyToOneOrderOrderBidirectionalService oneToManyOrderService;
	
	@GetMapping("/many-to-one-order-birdir")
	public String testMsg() {
		return "Welcome to One to many Mappint !";
	}

	@GetMapping("/many-to-one-order-birdir/list")
	public List<ManyToOneOrderOrderMasterBidirectionalEntity> list(Model model) {
		return oneToManyOrderService.list();
	}

	@PostMapping("/many-to-one-order-birdir/save")
	public String orderSave(@RequestBody ManyToOneOrderOrderMasterBidirectionalEntity saveObj) {
		if (saveObj == null) {
			return "No data found for save.";
		}
		return oneToManyOrderService.orderSave(saveObj);
	}

	@GetMapping("/many-to-one-order-birdir/view/{id}")
	public String findById(@PathVariable("id") long id) {
		ManyToOneOrderOrderMasterBidirectionalEntity findObj = null;
		try {
			findObj = oneToManyOrderService.findById(id);
			return findObj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error: Found !";
	}

	@PostMapping("/many-to-one-order-birdir/update")
	public String orderUpdate(@RequestBody ManyToOneOrderOrderMasterBidirectionalEntity updateObj) {
		if (updateObj != null) {
			return oneToManyOrderService.orderUpdate(updateObj);
		}
		return "Update failed, No date found !";
	}

	@GetMapping("/many-to-one-order-birdir/delete/{id}")
	public String orderDelete(@PathVariable("id") Long id) {
		return oneToManyOrderService.orderDelete(id);
	}

}

