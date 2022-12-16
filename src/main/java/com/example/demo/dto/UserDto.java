package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Data;

@Data
public class UserDto {

    private String password;
    private String email;
    private String phone;
    private String name;
    private int type;

    public static void entityToDto(User user, UserDto dto){
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setName(dto.getName());
    }

}
