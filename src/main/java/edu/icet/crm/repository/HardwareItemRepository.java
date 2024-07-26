package edu.icet.crm.repository;

import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.HardwareItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HardwareItemRepository extends CrudRepository<HardwareItemEntity,Long> {
    @Query("SELECT h.name FROM HardwareItemEntity h")
    List<String> findAllNames();

    @Query("SELECT h.itemId FROM HardwareItemEntity h")
    List<Long> findAllIds();
}
