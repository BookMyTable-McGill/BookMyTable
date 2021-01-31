package dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import model.*;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
  
    Customer findCustomerById(long id);
    Customer findCustomerByEmail(String email);
    Customer findCustomerByPhoneNumber(String phoneNumber);
    List<Customer> findCustomersByName(String name);
  
}
