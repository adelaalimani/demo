package com.example.demo.service;
import com.example.demo.dto.OpeningDto;
import com.example.demo.model.Opening;
import com.example.demo.repository.CandidateAppliedJobRepository;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.OpeningsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OpeningService {
    private final OpeningsRepository openingsRepository;
    private final CandidateAppliedJobRepository candidateAppliedJobRepository;
    private final CandidateRepository candidateRepository;

    public OpeningService(OpeningsRepository openingsRepository, CandidateAppliedJobRepository candidateAppliedJobRepository, CandidateRepository candidateRepository) {
        this.openingsRepository = openingsRepository;
        this.candidateAppliedJobRepository = candidateAppliedJobRepository;
        this.candidateRepository = candidateRepository;
    }

    public List<Opening> getAllOpenings() {
        return openingsRepository.findAll();
    }

    public Optional<Opening> getOpeningById(Long openingJobsId) {
        return openingsRepository.findById(openingJobsId);
    }

    public Opening createOpening(Opening openingJobs) {
        return openingsRepository.save(openingJobs);
    }

    public void deleteOpeningById(Long openingJobsId) {
        openingsRepository.deleteById(openingJobsId);
    }

    public void updateOpeningById(Long openingJobId, OpeningDto openingDetails) {
        Opening opening = openingsRepository.findById(openingJobId).orElseThrow(()-> new NoSuchElementException("Not Found"));
        OpeningDto.convertEntityToDto(opening, openingDetails);
        openingsRepository.save(opening);
    }


}