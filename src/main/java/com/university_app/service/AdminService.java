package com.university_app.service;

import java.util.List;

import com.university_app.entity.Admin;
import com.university_app.entity.Candidate;
import com.university_app.exception.CandidateNotFoundException;

public interface AdminService {

	public List<Candidate> viewAllCandidates();
	public double viewScoreById(int candidateId);
	public Candidate assignScore(int candidateId, double score) throws CandidateNotFoundException;
	public Admin registerAdmin(Admin admin);
	public String deleteCandidate(int candidateId) throws CandidateNotFoundException;
	List<Admin> viewAllAdmin();
	
	
	
}
