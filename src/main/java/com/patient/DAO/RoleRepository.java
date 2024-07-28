package com.patient.DAO;

import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>
{
}