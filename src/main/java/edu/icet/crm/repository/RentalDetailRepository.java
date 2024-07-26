package edu.icet.crm.repository;

import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.RentalDetailEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentalDetailRepository extends CrudRepository<RentalDetailEntity,Long> {
}
