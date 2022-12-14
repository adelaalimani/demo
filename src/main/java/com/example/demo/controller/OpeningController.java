package com.example.demo.controller;
import com.example.demo.dto.OpeningDto;
import com.example.demo.model.Opening;
import com.example.demo.service.OpeningService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opening")
public class OpeningController {
    private final OpeningService openingService;
    public OpeningController(OpeningService openingService) {
        this.openingService = openingService;
    }
    @GetMapping
    public List<Opening> getAllOpenings() {
        return openingService.getAllOpenings();
    }
    @GetMapping(value = "{openingJobId}")
    public Optional<Opening> getOpeningById(@PathVariable Long openingJobId) {
       return openingService.getOpeningById(openingJobId);
    }
    @PostMapping
    public Opening createOpening(@RequestBody Opening openingJobs) {
        return openingService.createOpening(openingJobs);
    }
    @DeleteMapping(value = "{openingJobId}")
    public void deleteOpeningById (@PathVariable(value = "openingJobId") Long openingJobId){
        openingService.deleteOpeningById(openingJobId);
    }
//



}
//@PutMapping(value="{openingJobId}")
//    public void updateOpeningById (@PathVariable("openingJobId") Long openingJobId, @RequestBody OpeningDto openingDetails) {
//        openingService.updateOpeningById(openingJobId, openingDetails);
//    }