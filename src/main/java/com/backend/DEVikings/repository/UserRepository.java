package com.backend.DEVikings.repository;

import com.backend.DEVikings.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository <User, Long>{
    User findByEmail(String email);

}