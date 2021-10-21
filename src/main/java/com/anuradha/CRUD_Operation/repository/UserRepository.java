package com.anuradha.CRUD_Operation.repository;

import com.anuradha.CRUD_Operation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
