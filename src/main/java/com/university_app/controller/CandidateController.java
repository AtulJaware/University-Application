package com.university_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.university_app.entity.Candidate;
import com.university_app.service.CandidateServiceImpl;

@RestController
public class CandidateController {

	@Autowired
	CandidateServiceImpl candidateService;
	
	@PostMapping("/register")
	public ResponseEntity<Candidate> registerCandidate(@RequestBody Candidate candidate) {
		
		return new ResponseEntity<Candidate>(candidateService.registerCandidate(candidate),HttpStatus.OK);
	}
	@GetMapping("/viewScore/{id}")
	public double viewScore(@PathVariable("id")int id) {
		return candidateService.viewScore(id);
	}
}
