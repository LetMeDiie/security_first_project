package com.project_spring.security.spring_security.repository;

import com.project_spring.security.spring_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
