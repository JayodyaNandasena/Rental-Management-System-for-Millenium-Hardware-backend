package edu.icet.crm.model;

import lombok.Data;
@Data
public class Customer {
    private Long customerId;
    private String name;
    private String city;
    private String contactNumber;
}
