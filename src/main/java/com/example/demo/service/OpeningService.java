package com.example.demo.service;
import com.example.demo.dto.OpeningDto;
import com.example.demo.model.Candidate;
import com.example.demo.model.CandidateAppliedJob;
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
//    public Opening updateOpeningById(Long openingJobId, Opening openingDetails) {
//        Opening o = openingsRepository.findById(openingJobId).orElseThrow(()-> new NoSuchElementException("Not Found"));
//        o.setDescription(openingDetails.getDescription());
//        o.setRequireExperience(openingDetails.getRequireExperience());
//        o.setSalaryLevel(openingDetails.getSalaryLevel());
//        o.setNotes(openingDetails.getNotes());
//        o.setPosition(openingDetails.getPosition());
//        return openingsRepository.save(o);
//    }

//    public void updateOpeningById(Long openingJobId, OpeningDto openingDetails) {
////        Opening opening = openingsRepository.findById(openingJobId).orElseThrow(() -> new NoSuchElementException("Not Found"));
////        List<CandidateAppliedJob> candidateAppliedJobs =  candidateAppliedJobRepository.findAll();
////        opening.setDescription(openingDetails.getDescription());
////        opening.setRequireExperience(openingDetails.getRequireExperience());
////        opening.setSalaryLevel(openingDetails.getSalaryLevel());
////        opening.setNotes(openingDetails.getNotes());
////        opening.setPosition(openingDetails.getPosition());
////        CandidateAppliedJob candidateAppliedJob = new CandidateAppliedJob();
////        candidateAppliedJob.setStatus(openingDetails.getStatus());
////        candidateAppliedJob.setOpening(opening);
////        candidateAppliedJobRepository.save(candidateAppliedJob);
////        opening.setCandidateAppliedJobs(candidateAppliedJobs);
////        openingsRepository.save(opening);
//        Opening opening = openingsRepository.findById(openingJobId).orElseThrow(() -> new NoSuchElementException("Not Found"));
//        List<Candidate> candidates =  candidateRepository.findAll();
//        opening.setDescription(openingDetails.getDescription());
//        opening.setRequireExperience(openingDetails.getRequireExperience());
//        opening.setSalaryLevel(openingDetails.getSalaryLevel());
//        opening.setNotes(openingDetails.getNotes());
//        opening.setPosition(openingDetails.getPosition());
//        CandidateAppliedJob candidateAppliedJob = new CandidateAppliedJob();
//        candidateAppliedJob.setStatus(openingDetails.getStatus());
//        candidateAppliedJob.setOpening(opening);
//        candidateAppliedJobRepository.save(candidateAppliedJob);
//        opening.setCandidateAppliedJobs(candidateAppliedJobs);
//        openingsRepository.save(opening);
//
//
//    }


}