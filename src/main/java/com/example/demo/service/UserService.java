package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Candidate;
import com.example.demo.model.User;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final CandidateService candidateService;
    private final CandidateRepository candidateRepository;

    public UserService(UserRepository userRepository, CandidateService candidateService, CandidateRepository candidateRepository) {
        this.userRepository = userRepository;
        this.candidateService = candidateService;
        this.candidateRepository = candidateRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserById(Long userId, UserDto userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("Not Found"));
        UserDto.entityToDto(user, userDetails);
        if (user.getCandidate() == null) {
            Candidate candidate = new Candidate();
            candidate.setType(UserDto.candidateTypeEnum(userDetails.getType()));
            candidate.setUser(user);
            candidateRepository.save(candidate);
        } else
            user.getCandidate().setType(UserDto.candidateTypeEnum(userDetails.getType()));

        userRepository.save(user);

    }

    public Candidate createUserCandidate(Candidate candidate, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("Not Found"));
        candidate.setUser(user);
        return candidateService.createCandidate(candidate);
    }
}

