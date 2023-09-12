package com.university_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university_app.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

}
