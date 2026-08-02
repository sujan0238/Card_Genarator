package com.paba.cardGenerator.repository;

import com.paba.cardGenerator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
