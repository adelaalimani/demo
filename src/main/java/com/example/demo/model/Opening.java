package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "opening", fetch = FetchType.EAGER)
    Set<CandidateAppliedJob> candidateAppliedJobs;

    @ManyToMany(mappedBy = "openings", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Candidate> candidates;
}