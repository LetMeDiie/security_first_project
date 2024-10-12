package com.project_spring.security.spring_security.repository;

import com.project_spring.security.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);


}
