package com.imranmadbar.joinMapping.manyToManyUnidirectional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManyToManyCourseUniConteoller {

	@Autowired
	private ManyToManyCourseUniService oneToManyOrderService;
	
	@GetMapping("/many-to-many-unidir")
	public String testMsg() {
		return "Welcome to One to many Mappint !";
	}

	@GetMapping("/many-to-many-unidir/list")
	public List<ManyToManyCourseUniEntity> list(Model model) {
		return oneToManyOrderService.list();
	}

	@PostMapping("/many-to-many-unidir/save")
	public String orderSave(@RequestBody ManyToManyCourseUniEntity saveObj) {
		if (saveObj == null) {
			return "No data found for save.";
		}
		return oneToManyOrderService.orderSave(saveObj);
	}

	@GetMapping("/many-to-many-unidir/view/{id}")
	public String findById(@PathVariable("id") long id) {
		ManyToManyCourseUniEntity findObj = null;
		try {
			findObj = oneToManyOrderService.findById(id);
			return findObj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error: Found !";
	}

	@PostMapping("/many-to-many-unidir/update")
	public String orderUpdate(@RequestBody ManyToManyCourseUniEntity updateObj) {
		if (updateObj != null) {
			return oneToManyOrderService.orderUpdate(updateObj);
		}
		return "Update failed, No date found !";
	}

	@GetMapping("/many-to-many-unidir/delete/{id}")
	public String orderDelete(@PathVariable("id") Long id) {
		return oneToManyOrderService.orderDelete(id);
	}

}

