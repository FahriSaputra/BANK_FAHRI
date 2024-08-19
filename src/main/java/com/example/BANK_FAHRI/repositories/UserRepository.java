package com.example.BANK_FAHRI.repositories;

import com.example.BANK_FAHRI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
