package com.example.demo.service;
import com.example.demo.model.Candidate;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final CandidateService candidateService;

    public UserService(UserRepository userRepository, CandidateService candidateService) {
        this.userRepository = userRepository;
        this.candidateService = candidateService;
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
    public User updateUserById(Long userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException("Not Found"));
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setName(userDetails.getName());
        return userRepository.save(user);
    }

    public Candidate createUserCandidate(Candidate candidate, Long userId ) {
        User user = userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException("Not Found"));
        candidate.setUser(user);
        return candidateService.createCandidate(candidate);
    }
}

