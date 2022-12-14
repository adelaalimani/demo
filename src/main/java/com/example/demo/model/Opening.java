package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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

//    @OneToMany(mappedBy = "opening", fetch = FetchType.EAGER)
//    List<CandidateAppliedJob> candidateAppliedJobs;
    @JsonIgnore
    @ManyToMany(mappedBy = "openings")
    private List<Candidate> candidates;
}