package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String firstName;
    private String secondName;
    private String contactNumber;
    private String email;
}
