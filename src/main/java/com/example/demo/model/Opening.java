package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="openings")
public class Opening implements Serializable {
    @Id
    @SequenceGenerator(name = "opening_sequence", sequenceName = "opening_sequence", allocationSize = 1)
    @GeneratedValue(generator = "opening_sequence", strategy = GenerationType.SEQUENCE)
    private Long openingId;
    private String description;
    private String requireExperience;

    private String salaryLevel;
    private String notes;

    private String position;

}