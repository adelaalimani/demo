package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_applied_job")
public class CandidateAppliedJob {
    @Id
    @SequenceGenerator(name = "candidate_applied_sequence", sequenceName = "candidate_applied_sequence", allocationSize = 1)
    @GeneratedValue(generator = "candidate_applied_sequence", strategy = GenerationType.SEQUENCE)
    private Long candidateAppliedJobId;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "candidateId", referencedColumnName = "candidateId")
    Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "openingId", referencedColumnName = "openingId")
    Opening opening;

}
