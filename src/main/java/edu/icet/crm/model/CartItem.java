package edu.icet.crm.model;

import lombok.Data;

@Data
public class CartItem {
    private Long itemId;
    private Integer quantity;
    private Double totalItemCost;
}
