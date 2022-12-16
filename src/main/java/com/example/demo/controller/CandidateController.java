package com.example.demo.controller;

import com.example.demo.dto.CandidateDto;
import com.example.demo.model.Candidate;
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
    public void deleteCandidateById(@PathVariable(value = "candidateId") Long candidateId) {
        candidateService.deleteCandidateById(candidateId);
    }

    @PutMapping(value = "/update/")
    public void updateCandidateType(@RequestParam Long candidateId,
                                    @RequestParam int type) {
        candidateService.updateCandidateType(candidateId, type);
    }

    @PutMapping(value = "/appliedJobs/")
    //http://localhost:8080/api/candidate/appliedJobs/?candidateId=1&openingId=3&status=2
    public void candidatesAppliedJobs(
            @RequestParam Long candidateId,
            @RequestParam Long openingId,
            @RequestParam int status) {
        candidateService.candidateAppliedJobs(candidateId, openingId, status);
    }
}