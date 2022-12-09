package com.example.demo.service;
import com.example.demo.model.Candidate;
import com.example.demo.repository.CandidateRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
    public Optional<Candidate> getCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId);
    }
    public Candidate createCandidate(Candidate candidate) {

        return candidateRepository.save(candidate);
    }
    public void deleteCandidateById(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
    public Candidate updateCandidate(Long candidateId, Candidate candidateDetails) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(()-> new NoSuchElementException("Not Found"));
        if (candidate != null) {
            candidate.setType(candidateDetails.getType());
        }
        return candidateRepository.save(Objects.requireNonNull(candidate));
    }

}
