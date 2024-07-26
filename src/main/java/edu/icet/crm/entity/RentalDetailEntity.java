package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "rental_detail")
public class RentalDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detail_id")
    private Long detailId;
    @Column(name = "rental_id")
    private Long rentalId;
    @Column(name = "item_id")
    private Long itemId;
    private BigDecimal totalItemCost;
    private Integer qty;
}
