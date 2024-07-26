package edu.icet.crm.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class RentalCreate {
    private String customerMobile;
    private LocalDate rentalDate;
    private LocalDate dueDate;
    private Double totalCost;
    private List<CartItem> items;
}
