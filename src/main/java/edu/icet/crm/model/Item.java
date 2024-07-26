package edu.icet.crm.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private Long itemId;
    private String name;
    private Double rentalPerDay;
    private Double finePerDay;
    private Boolean availability;
}
