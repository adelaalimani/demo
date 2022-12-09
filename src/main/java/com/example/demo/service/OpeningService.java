package com.example.demo.service;
import com.example.demo.model.Opening;
import com.example.demo.repository.OpeningsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class OpeningService {
     private final OpeningsRepository openingsRepository;
    public OpeningService(OpeningsRepository openingsRepository) {
        this.openingsRepository = openingsRepository;
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
    public Opening updateOpeningById(Long openingJobId, Opening openingDetails) {
        Opening o = openingsRepository.findById(openingJobId).orElseThrow(()-> new NoSuchElementException("Not Found"));
        o.setDescription(openingDetails.getDescription());
        o.setRequireExperience(openingDetails.getRequireExperience());
        o.setSalaryLevel(openingDetails.getSalaryLevel());
        o.setNotes(openingDetails.getNotes());
        o.setPosition(openingDetails.getPosition());
        return openingsRepository.save(o);
    }



    }


