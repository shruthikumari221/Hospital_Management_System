package com.patient.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine, Integer>
{

}