package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private String itemId;
    private String category;
    private String productName;
    private int qtyOnHand;
    private double unitPrice;
}
