package bookmytable.service;

import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bookmytable.dao.AdminRepository;

import bookmytable.model.Admin;


@Service
public class AdminRegistrationService {
	
	  @Autowired
	  private AdminRepository adminRepository;
	  
	  
	  @Transactional
	  public Admin createAdmin(String name, String email, String password) {
	    name = name.trim();
	    email = email.trim();
	    password = password.trim();
	    
	    
	    if (name == null || name.compareTo("")==0
	        || email == null || email.compareTo("")==0
	        || password == null || password.compareTo("")==0) {
	      throw new IllegalArgumentException("Missing Information");
	    }
	    
	    if (!validateEmail(email)) {
	      throw new IllegalArgumentException("Invalid Email");
	    }
	    
	   Admin adminEmailCheck = adminRepository.findAdminByEmail(email);
	    if (adminEmailCheck!= null) {
	      throw new IllegalArgumentException("An adminstrative account with this email already exists");
	    }
	    
	    if (password.length() < 6) {
	      throw new IllegalArgumentException("Invalid Password");
	    }

	   
	    
	    Admin admin = new Admin();
	    admin.setName(name);
	    admin.setEmail(email);
	    admin.setPassword(password);
	  
	    adminRepository.save(admin);
	    
	    return admin;
	  }
	  
	  
	  @Transactional
	  public Admin modifyAdminName(long adminID, String name) {
		  
		  	Admin admin = adminRepository.findAdminById(adminID);
		  
		  	name = name.trim();
		   
		    
		    
		    if (name == null || name.compareTo("")==0) {
		       
		      throw new IllegalArgumentException("Missing name");
		    }
		
	
		    if(admin.getName().equalsIgnoreCase(name) == false) {
		    	admin.setName(name);
		    }

		    adminRepository.save(admin);
		    
		    return admin;
		    
	  }
	  
	  
	  
	  @Transactional
	  public Admin modifyAdminEmail(long adminID, String newEmail) {
		  
		  	Admin admin = adminRepository.findAdminById(adminID);
		  
		  	
		    newEmail = newEmail.trim();
		    
		    
		    if ( newEmail == null || newEmail.compareTo("")==0) {
		       
		      throw new IllegalArgumentException("Missing Email");
		    }
		    
		    if (!validateEmail(newEmail)) {
		      throw new IllegalArgumentException("Invalid Email");
		    }
		    
		    
		    
		    if(admin.getEmail().equalsIgnoreCase(newEmail) == false) {
		    	Admin emailCheck = adminRepository.findAdminByEmail(newEmail);
		 	    if (emailCheck != null) {
		 	      throw new IllegalArgumentException("An account with this email already exists");
		 	    }
		 	    
		 	   admin.setEmail(newEmail);
		 	    
		    }
		    
		   
		    
		    adminRepository.save(admin);
		    
		    return admin;
		    
	  }
	  
	  
	  
	  
	  @Transactional
	  public Admin modifyAdminPassword(long adminID, String oldPassword, String newPassword) {
		  
		  	Admin admin = adminRepository.findAdminById(adminID);
		  
		  	newPassword = newPassword.trim();
		    
		    if ( newPassword == null || newPassword.compareTo("")==0) {
		       
		      throw new IllegalArgumentException("Missing Password");
		    }
		    
		    
		    if(passwordCheck(admin, oldPassword) == false) {
		    	 throw new IllegalArgumentException("The password you have entered is incorrect");	
		    }
		    
		    else if(passwordCheck(admin, oldPassword) == true) {
		    	
		    	if(newPassword.length() < 6) {
		    	 throw new IllegalArgumentException("Your new password is too short");
		    	}
		    	
		    	else if(admin.getPassword().equals(newPassword) ==true) {
		    		 throw new IllegalArgumentException("Please enter a new password");
				    }
		    	
		    	else
		    		admin.setPassword(newPassword);
				    
		    	
		    }
		
		    
		   
		    
		    adminRepository.save(admin);
		    
		    return admin;
		    
	  }
	  
	  
	  	
	  
	  
	  		private static boolean validateEmail(String email) {
		  	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
		            + "A-Z]{2,7}$";
		    Pattern pattern = Pattern.compile(emailRegex);
		    return pattern.matcher(email).matches();
		  }
	  		
	  		private static boolean passwordCheck(Admin admin, String password) {
	  			String pass = admin.getPassword();
	  			
	  			if(pass.equalsIgnoreCase(password))
	  				return true;
	  			
	  			return false;
	  		}
	  		
	  		
	  		
	  
	  

}


