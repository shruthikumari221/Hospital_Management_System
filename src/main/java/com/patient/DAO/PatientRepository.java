package com.patient.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer>
{

}