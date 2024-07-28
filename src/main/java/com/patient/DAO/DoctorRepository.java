package com.patient.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{

}