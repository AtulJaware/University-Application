package com.university_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university_app.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
