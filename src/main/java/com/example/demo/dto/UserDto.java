package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {

    private String password;
    private String email;
    private String phone;
    private String name;
    private int type;
}
