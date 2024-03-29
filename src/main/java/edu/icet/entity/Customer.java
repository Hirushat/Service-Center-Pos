package edu.icet.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Customer {
    @Id
    private String id;
    private String name;
    private String contactNumber;
    private String email;
}
