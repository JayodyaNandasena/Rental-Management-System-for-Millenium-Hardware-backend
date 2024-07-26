package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "rental")
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rental_id")
    private Long rentalId;
    @Column(nullable = false)
    private LocalDate rentalDate;
    @Column(nullable = false)
    private LocalDate dueDate;
    private LocalDate returnDate;
    @Column(nullable = false)
    private BigDecimal totalCost;
    private BigDecimal fine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "rental_detail",
//        joinColumns = @JoinColumn(name = "item_id",
//            referencedColumnName = "item_id"),
//        inverseJoinColumns = @JoinColumn(name = "rental_id",
//                referencedColumnName = "rental_id")
//    )
//    private List<HardwareItemEntity> itemList;

}
