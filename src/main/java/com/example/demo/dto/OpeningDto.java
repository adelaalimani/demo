package com.example.demo.dto;

import com.example.demo.model.Opening;
import com.example.demo.model.Status;
import lombok.Data;
import static com.example.demo.model.Status.*;

@Data
public class OpeningDto {

    private String description;
    private String requireExperience;
    private String salaryLevel;
    private String notes;
    private String position;
    private int status;

    private Status convertStatusToString(int statusInt) {
        return switch (statusInt) {
            case 0 -> PHONE_SCREEN;
            case 1 -> INTERVIEW;
            case 2 -> AWAITING_DECISION;
            default -> null;
        };
    }

    public static void convertEntityToDto(Opening opening, OpeningDto dto){
        opening.setDescription(dto.getDescription());
        opening.setRequireExperience(dto.getRequireExperience());
        opening.setSalaryLevel(dto.getSalaryLevel());
        opening.setNotes(dto.getNotes());
        opening.setPosition(dto.getPosition());
        opening.setStatus(dto.convertStatusToString(dto.getStatus()));
    }
}
