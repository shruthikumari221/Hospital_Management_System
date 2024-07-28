package com.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.DAO.ContactRepository;
import com.patient.entity.Contact;

@Service
public class ContactService
{
    @Autowired
    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;
    }
    public void save(Contact contact)
    {
        contactRepository.save(contact);
    }

}