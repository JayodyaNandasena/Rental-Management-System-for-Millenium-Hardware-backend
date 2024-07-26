package edu.icet.crm.model;

import lombok.Data;

@Data
public class ItemCreate {
    private String name;
    private Double rentalPerDay;
    private Double finePerDay;
    private Boolean availability;
}
