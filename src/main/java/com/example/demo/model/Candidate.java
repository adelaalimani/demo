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
@Table (name="candidates")
public class Candidate implements Serializable {
    @Id
    @SequenceGenerator(name = "candidate_sequence", sequenceName = "candidate_sequence", allocationSize = 1)
    @GeneratedValue(generator = "candidate_sequence", strategy = GenerationType.SEQUENCE)
    private Long candidateId;
    private int type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

//    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER)
//    List<CandidateAppliedJob> candidateAppliedJobs;
@ManyToMany
@JoinTable(
        name="candidate_opening",
        joinColumns = @JoinColumn(name="candidate_id", referencedColumnName = "candidateId"),
        inverseJoinColumns = @JoinColumn(name="opening_id", referencedColumnName = "openingId")
)
      private List<Opening> openings;



}
