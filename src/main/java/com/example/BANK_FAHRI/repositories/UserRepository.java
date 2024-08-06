package com.example.BANK_FAHRI.repositories;

import com.example.BANK_FAHRI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
