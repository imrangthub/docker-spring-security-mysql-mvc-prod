package com.imranmadbar.joinMapping.oneToOneBiDir;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToOneBiDirOrderController {

	@Autowired
	private OneToOneBiDirOrderService oneToOneOrderService;
	
	@GetMapping("/one-to-one-order-bidir")
	public String testMsg() {
		return "Welcome to One to One Mappint !";
	}

	@GetMapping("/one-to-one-order-bidir/list")
	public List<OneToOneBiDirOrderMasterEntity> list(Model model) {
		return oneToOneOrderService.list();
	}

	@PostMapping("/one-to-one-order-bidir/save")
	public String orderSave(@RequestBody OneToOneBiDirOrderMasterEntity saveObj) {
		if (saveObj == null) {
			return "No data found for save.";
		}
		return oneToOneOrderService.orderSave(saveObj);
	}

	@GetMapping("/one-to-one-order-bidir/view/{id}")
	public String findById(@PathVariable("id") long id) {
		OneToOneBiDirOrderMasterEntity findObj = null;
		try {
			findObj = oneToOneOrderService.findById(id);
			return findObj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error: Found !";
	}

	@PostMapping("/one-to-one-order-bidir/update")
	public String orderUpdate(@RequestBody OneToOneBiDirOrderMasterEntity updateObj) {
		if (updateObj != null) {
			return oneToOneOrderService.orderUpdate(updateObj);
		}
		return "Update failed, No date found !";
	}

	@GetMapping("/one-to-one-order-bidir/delete/{id}")
	public String orderDelete(@PathVariable("id") Long id) {
		return oneToOneOrderService.orderDelete(id);
	}

}