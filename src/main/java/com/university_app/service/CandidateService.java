package com.university_app.service;

import com.university_app.entity.Candidate;

public interface CandidateService {

	public Candidate registerCandidate(Candidate candidate);
	public double viewScore(int candidateId);
}
