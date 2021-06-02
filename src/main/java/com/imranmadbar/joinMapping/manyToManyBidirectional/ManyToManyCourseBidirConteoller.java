package com.imranmadbar.joinMapping.manyToManyBidirectional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManyToManyCourseBidirConteoller {

	@Autowired
	private ManyToManyCourseBidirService oneToManyOrderService;
	
	@GetMapping("/many-to-many-bidir")
	public String testMsg() {
		return "Welcome to One to many Mappint !";
	}

	@GetMapping("/many-to-many-bidir/list")
	public List<ManyToManyCourseBidirEntity> list(Model model) {
		return oneToManyOrderService.list();
	}

	@PostMapping("/many-to-many-bidir/save")
	public String orderSave(@RequestBody ManyToManyCourseBidirEntity saveObj) {
		if (saveObj == null) {
			return "No data found for save.";
		}
		return oneToManyOrderService.orderSave(saveObj);
	}

	@GetMapping("/many-to-many-bidir/view/{id}")
	public String findById(@PathVariable("id") long id) {
		ManyToManyCourseBidirEntity findObj = null;
		try {
			findObj = oneToManyOrderService.findById(id);
			return findObj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error: Found !";
	}

	@PostMapping("/many-to-many-bidir/update")
	public String orderUpdate(@RequestBody ManyToManyCourseBidirEntity updateObj) {
		if (updateObj != null) {
			return oneToManyOrderService.orderUpdate(updateObj);
		}
		return "Update failed, No date found !";
	}

	@GetMapping("/many-to-many-bidir/delete/{id}")
	public String orderDelete(@PathVariable("id") Long id) {
		return oneToManyOrderService.orderDelete(id);
	}

}

