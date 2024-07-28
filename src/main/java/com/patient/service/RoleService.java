package com.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.stereotype.Service;

import com.patient.DAO.RoleRepository;

@Service
public class RoleService
{
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles()
    {
        return roleRepository.findAll();
    }
}