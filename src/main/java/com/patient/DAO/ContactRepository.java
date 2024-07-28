package com.patient.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>
{
}