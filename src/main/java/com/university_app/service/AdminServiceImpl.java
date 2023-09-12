package com.university_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university_app.entity.Admin;
import com.university_app.entity.Candidate;
import com.university_app.exception.CandidateNotFoundException;
import com.university_app.repository.AdminRepository;
import com.university_app.repository.CandidateRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	CandidateRepository candidateRepo;

	@Override
	public List<Candidate> viewAllCandidates() {
		List<Candidate> list = candidateRepo.findAll();
		return list;
	}

	@Override
	public double viewScoreById(int candidateId) {
		Candidate candidate=candidateRepo.findById(candidateId)
				.orElseThrow(()-> new CandidateNotFoundException("Candidate Not Found With Candidate ID "+candidateId));
		
		
		return candidate.getScore();
	}

	@Override
	public Candidate assignScore(int candidateId, double score) throws CandidateNotFoundException {
		Candidate candidate = candidateRepo.findById(candidateId)
				.orElseThrow(()-> new CandidateNotFoundException("Candidate Not Found With Candidate ID "+candidateId));
		
		candidate.setScore(score);
		candidateRepo.save(candidate);
		
		return candidate;
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}

	@Override
	public List<Admin> viewAllAdmin() {
		List<Admin> list = adminRepo.findAll();
		return list;
	}

	@Override
	public String deleteCandidate(int candidateId) throws CandidateNotFoundException {
		Candidate cand=candidateRepo.findById(candidateId).orElseThrow(()-> new CandidateNotFoundException("Candidate Not Found With Candidate ID "+candidateId));
		candidateRepo.delete(cand);
		return "Candidate Deleted Sucessfully with id "+candidateId;
	}
}
