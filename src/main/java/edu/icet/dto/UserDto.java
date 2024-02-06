package edu.icet.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String eMail;
    private String passWord;
    private String userType;
}
