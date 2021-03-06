package bookmytable.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import bookmytable.dto.AdminDTO;
import bookmytable.model.Admin;
import bookmytable.service.AdminRegistrationService;


@CrossOrigin(origins = "*")
@RestController
public class AdminRegistrationController {
	
	 @Autowired
	 private AdminRegistrationService adminRegistrationService;
	  
	 
	  @PostMapping(value = { "/admin/register", "/admin/register/" })
	  public AdminDTO registerAdmin(@RequestParam(name = "name") String name,
	      @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
	    
	    Admin admin = adminRegistrationService.createAdmin(name, email, password);
	    return Converters.convertToDto(admin);
	  }
	  
	  @PostMapping(value= {"/admin/edit/name","/admin/edit/name/"})
	  public AdminDTO modifyAdminName(@RequestParam(name="admin") long adminID, @RequestParam(name="newName") String newName) {
		  
		  Admin admin = adminRegistrationService.modifyAdminName(adminID, newName);
		  
		  return Converters.convertToDto(admin);
		  
	  }
	  
	  @PostMapping(value= {"/admin/edit/email","/admin/edit/email/"})
	  public AdminDTO modifyAdminEmail(@RequestParam(name="admin") long adminID, @RequestParam(name="newEmail") String newEmail) {
		  
		  Admin admin = adminRegistrationService.modifyAdminEmail(adminID, newEmail);
		  
		  return Converters.convertToDto(admin);
		  
	  }
	  
	  
	  @PostMapping(value= {"/admin/edit/password","/admin/edit/password/"})
	  public AdminDTO modifyAdminPassword(@RequestParam(name="admin") long adminID, @RequestParam(name="oldPassword") String oldPassword, 
			  @RequestParam(name="newPassword") String newPassword) {
		  
		  Admin admin = adminRegistrationService.modifyAdminPassword(adminID, oldPassword, newPassword);
		  
		  return Converters.convertToDto(admin);
		  
	  }
	

}
