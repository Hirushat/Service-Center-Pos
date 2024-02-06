package edu.icet.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Order {
    private String orderId;
    private String customerName;
    private String description;
    private String orderDate;
    private String status;
}
