package com.university_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.university_app.entity.Admin;
import com.university_app.entity.Candidate;
import com.university_app.exception.CandidateNotFoundException;
import com.university_app.service.AdminServiceImpl;
import com.university_app.service.CandidateService;

@RestController
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	
	//Register admin
	@PostMapping("/register/admin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminService.registerAdmin(admin), HttpStatus.OK);
    }
	
	//view all candidates
	@GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getAllCandidate(){
        return new ResponseEntity<List<Candidate>>(adminService.viewAllCandidates(),HttpStatus.OK);
    }
	
	//view all admins
		@GetMapping("/admin")
	    public ResponseEntity<List<Admin>> getAllAdmin(){
	        return new ResponseEntity<List<Admin>>(adminService.viewAllAdmin(),HttpStatus.OK);
	    }
	
	//assign score to candidate
	@PatchMapping("candidate/{id}/{score}")
	    public ResponseEntity<Candidate> assignScore(@PathVariable("id") int id ,@PathVariable("score") double score) throws CandidateNotFoundException {
	        return new ResponseEntity<Candidate>(adminService.assignScore(id,score), HttpStatus.OK);
	    }
	
	//View score by candidate ID
	@GetMapping("/candidate/{id}")
	public double viewScoreById(@PathVariable("id")int id) {
		return adminService.viewScoreById(id);
	}
	
	//delete candidate by id
	@DeleteMapping("/delete/{id}")
	public String deleteCandidate(@PathVariable("id") int id) {
		return adminService.deleteCandidate(id);
	}
}