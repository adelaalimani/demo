package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String password;
    private String email;
    private String phone;
    private String name;
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    public Candidate candidate;

}