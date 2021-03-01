package bookmytable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dto.AdminDTO;
import bookmytable.model.Admin;
import bookmytable.service.AdminLoginService;

@CrossOrigin(origins = "*")
@RestController
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	@PostMapping(value = { "/admin/login", "/admin/login/" })
	private AdminDTO adminLogin(@RequestParam(name = "password") String password,
			@RequestParam(name = "email") String email) {
		boolean loginCheck = false;
		Admin admin = adminLoginService.getAdminByEmail(email);
		if (admin != null) {
		 loginCheck = adminLoginService.loginAdmin(admin, email, password);
	
		}
		
		if(loginCheck == true) {
			return Converters.convertToDto(admin);
		}
		
		else
			return null;		

	}

}
