package edu.icet.crm.repository;

import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.HardwareItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface HardwareItemRepository extends CrudRepository<HardwareItemEntity,Long> {
}
