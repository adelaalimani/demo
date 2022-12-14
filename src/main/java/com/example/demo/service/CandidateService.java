package com.example.demo.service;
import com.example.demo.dto.CandidateDto;
import com.example.demo.model.Candidate;
import com.example.demo.model.CandidateAppliedJob;
import com.example.demo.model.Opening;
import com.example.demo.repository.CandidateAppliedJobRepository;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.OpeningsRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final OpeningsRepository openingsRepository;
    private final CandidateAppliedJobRepository candidateAppliedJobRepository;

    public CandidateService(CandidateRepository candidateRepository, OpeningsRepository openingsRepository, CandidateAppliedJobRepository candidateAppliedJobRepository) {
        this.candidateRepository = candidateRepository;
        this.openingsRepository = openingsRepository;
        this.candidateAppliedJobRepository = candidateAppliedJobRepository;
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

//    public void updateCandidateById(Long candidateId, CandidateDto candidateDetails) {
//        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new NoSuchElementException("Not Found"));
//        List<CandidateAppliedJob> candidateAppliedJobs =  candidateAppliedJobRepository.findAll();
//    if (candidate != null) {
//            candidate.setType(candidateDetails.getType());
//            CandidateAppliedJob candidateAppliedJob = new CandidateAppliedJob();
//            candidateAppliedJob.setStatus(candidateDetails.getStatus());
//            candidateAppliedJob.setCandidate(candidate);
//            candidateAppliedJobRepository.save(candidateAppliedJob);
//           candidate.setCandidateAppliedJobs(candidateAppliedJobs);
//
//        }
//
//         candidateRepository.save(candidate);
//        }

    public void candidateAppliedJobs(Long candidateId, Long openingId){
         List<Opening> openings = openingsRepository.findAll();
        Candidate candidate= candidateRepository.findById(candidateId).orElseThrow(()-> new NoSuchElementException("Not found"));
        Opening opening=openingsRepository.findById(openingId).orElseThrow(()-> new NoSuchElementException("Not found"));;
        openings.add(opening);
        candidateRepository.save(candidate);
    }


}
