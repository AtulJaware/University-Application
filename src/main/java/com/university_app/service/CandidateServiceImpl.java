package com.university_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university_app.entity.Candidate;
import com.university_app.exception.CandidateNotFoundException;
import com.university_app.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService{

	
	@Autowired
	public CandidateRepository candidateRepo;

	@Override
	public Candidate registerCandidate(Candidate candidate) {
		
		return candidateRepo.save(candidate);
	}

	@Override
	public double viewScore(int candidateId) {
		Candidate candidate=candidateRepo.findById(candidateId).orElseThrow(()-> new CandidateNotFoundException("Candidate Not Found With Candidate ID "+candidateId));
		
		
		return candidate.getScore();
	}
}
