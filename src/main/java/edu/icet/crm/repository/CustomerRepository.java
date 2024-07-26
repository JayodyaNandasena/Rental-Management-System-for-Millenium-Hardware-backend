package edu.icet.crm.repository;

import edu.icet.crm.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByContactNumber(String contactNumber);
    @Query("SELECT c.contactNumber FROM CustomerEntity c")
    List<String> findAllContactNumbers();
}
