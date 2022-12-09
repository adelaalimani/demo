package com.example.demo.controller;
import com.example.demo.model.Candidate;
import com.example.demo.service.CandidateService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    private final CandidateService candidateService;
    public CandidateController(CandidateService candidateService) {
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
    @PutMapping(value="{candidateId}")
    public Candidate updateCandidate(@PathVariable(value = "candidateId") Long candidateId, @RequestBody Candidate candidateDetails) {
        return candidateService.updateCandidate(candidateId, candidateDetails);
    }

}