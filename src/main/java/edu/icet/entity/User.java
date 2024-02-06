package edu.icet.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String userId;
    private String eMail;
    private String passWord;
    private String userType;
}
