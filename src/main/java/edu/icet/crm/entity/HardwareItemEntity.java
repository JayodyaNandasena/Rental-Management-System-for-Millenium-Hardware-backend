package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "hardware_item")
public class HardwareItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal rentalPerDay;
    @Column(nullable = false)
    private BigDecimal finePerDay;
    private Boolean availability;

//    @ManyToMany(mappedBy = "itemList")
//    private List<RentalEntity> rentalList;
}
