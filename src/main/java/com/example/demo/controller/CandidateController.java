package com.example.demo.controller;
import com.example.demo.dto.CandidateDto;
import com.example.demo.model.Candidate;
import com.example.demo.model.Opening;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.OpeningsRepository;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    private final CandidateService candidateService;
@Autowired
    public CandidateController(CandidateService candidateService, CandidateRepository candidateRepository, OpeningsRepository openingsRepository) {
        this.candidateService = candidateService;
    }
    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping(value = "{candidateId}")
    public Optional<Candidate> getCandidateById(@PathVariable Long candidateId) {
        return candidateService.getCandidateById(candidateId);
    }
    @DeleteMapping(value = "{candidateId}")
    public void deleteCandidateById(@PathVariable(value = "candidateId") Long candidateId){
        candidateService.deleteCandidateById(candidateId);
    }
//    @PutMapping(value="{candidateId}")
//    public void updateCandidateById(@PathVariable(value = "candidateId") Long candidateId, @RequestBody CandidateDto candidateDetails) {
//         candidateService.updateCandidateById(candidateId, candidateDetails);
//    }
    @PutMapping(value ="/{candidateId}/opening/{openingId}")
    public void candidatesAppliedJobs(
            @PathVariable Long candidateId,
            @PathVariable Long openingId
    ){
       candidateService.candidateAppliedJobs(candidateId, openingId);
    }
}