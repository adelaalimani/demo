package com.example.demo.dto;

import com.example.demo.model.CandidateType;
import com.example.demo.model.User;
import lombok.Data;

import static com.example.demo.model.CandidateType.*;

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

    public static CandidateType candidateTypeEnum(int type){
        return switch (type) {
            case 0 -> UNSOLICITED;
            case 1 -> SOLICITED;
            case 2 -> INTERNAL;
            default -> null;
        };

    }
}
