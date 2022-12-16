package com.example.demo.dto;

import com.example.demo.model.Opening;
import com.example.demo.statics.EnumStatics;
import lombok.Data;

@Data
public class OpeningDto {

    private String description;
    private String requireExperience;
    private String salaryLevel;
    private String notes;
    private String position;
    private int status;

    public static void convertEntityToDto(Opening opening, OpeningDto dto){
        opening.setDescription(dto.getDescription());
        opening.setRequireExperience(dto.getRequireExperience());
        opening.setSalaryLevel(dto.getSalaryLevel());
        opening.setNotes(dto.getNotes());
        opening.setPosition(dto.getPosition());
        opening.setStatus(EnumStatics.statusEnum(dto.getStatus()));
    }
}
