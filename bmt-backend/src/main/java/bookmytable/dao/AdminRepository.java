package bookmytable.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bookmytable.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
	Admin findAdminById(long id);

	Admin findAdminByEmail(String email);

	List<Admin> findAdminsByName(String name);
}
