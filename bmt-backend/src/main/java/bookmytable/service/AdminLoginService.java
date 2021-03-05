package bookmytable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.AdminRepository;
import bookmytable.model.Admin;

@Service
public class AdminLoginService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Transactional
	public boolean loginAdmin(Admin admin, String email, String password) {
		String error = "";

		if (admin == null) {
			error = "Admin does not exist.";
			throw new IllegalArgumentException(error);

		} else if (admin.getId() == null) {
			error = "Admin does not exist.";
			throw new IllegalArgumentException(error);

		} else if (admin.getPassword().equals(password) == false) {
			error = "Admin password does not match input password.";
			throw new IllegalArgumentException(error);

		} else if (admin.getEmail().equals(email) == false) {
			error = "Admin email does not match input email.";
			throw new IllegalArgumentException(error);

		} else {
			// set login status of admin to true
			return true;
		}
	}

	@Transactional
	public Admin getAdminByEmail(String email) {
		return adminRepository.findAdminByEmail(email);
	}

	@Transactional
	public Admin getAdminById(long id) {
		return adminRepository.findAdminById(id);
	}
	
	@Transactional
	public List<Admin> getAdminsByName(String name) {
		return toList(adminRepository.findAdminsByName(name));
	}
	
	 private <T> List<T> toList(Iterable<T> iterable) {
	        List<T> resultList = new ArrayList<T>();
	        for (T t : iterable) {
	            resultList.add(t);
	        }
	        return resultList;
	    }
}
