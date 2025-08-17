
package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.model.UserAccount;
import com.example.jobportal.repository.JobRepository;
import com.example.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired private JobRepository jobRepository;
    @Autowired private UserRepository userRepository;

    @GetMapping("/jobs")
    public List<Job> getJobs() { return jobRepository.findAll(); }

    @PostMapping("/jobs")
    public Job addJob(@RequestBody Job job) { return jobRepository.save(job); }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserAccount user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String phone,
                                   @RequestParam MultipartFile resume,
                                   @RequestParam String coverLetter) throws IOException {
        Path dir = Paths.get("uploads");
        if(!Files.exists(dir)) Files.createDirectories(dir);
        Path file = dir.resolve(System.currentTimeMillis() + "_" + resume.getOriginalFilename());
        resume.transferTo(file);
        return ResponseEntity.ok("Application received for " + name);
    }
}
