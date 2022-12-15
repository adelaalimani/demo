package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name="candidates")
public class Candidate implements Serializable {
    @Id
    @SequenceGenerator(name = "candidate_sequence", sequenceName = "candidate_sequence", allocationSize = 1)
    @GeneratedValue(generator = "candidate_sequence", strategy = GenerationType.SEQUENCE)
    private Long candidateId;
    @Enumerated(EnumType.STRING)
    private CandidateType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER)
    Set<CandidateAppliedJob> candidateAppliedJobs;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "candidate_opening",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "opening_id")
    )
    private List<Opening> openings;



}
