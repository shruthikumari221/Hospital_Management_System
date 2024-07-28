package com.patient.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.Disease;


public interface DiseaseRepository extends JpaRepository<Disease, Integer>
{

}