package com.imranmadbar.userRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserRolesController {

	@Autowired
	private UserRolesService rolesService;

	@GetMapping("/user-role")
	public String index(Model model) {
		model.addAttribute("userRoleList", rolesService.list());
		return "userRole/home";
	}

	@GetMapping("/user-role/list")
	public String list(Model model) {
		model.addAttribute("userRoleList", rolesService.list());
		return "userRole/home";
	}

	@GetMapping("/user-role/create")
	public String create(Model model) {
		UserRoleEntity obj = new UserRoleEntity();
		model.addAttribute("userRoleObj", obj);
		return "userRole/userRoleCreate";
	}

	@PostMapping("/user-role/save")
	public String saveUserRole(UserRoleEntity userRoleObj, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "userRole/userRoleCreate";
		}
		rolesService.roleSave(userRoleObj);
		return "redirect:/user-role/list";
	}

	@GetMapping("/user-role/delete/{id}")
	public String roleDelete(Model model, @PathVariable("id") Long id) {
		rolesService.roleDelete(id);
		return "redirect:/user-role/list";
	}


}
