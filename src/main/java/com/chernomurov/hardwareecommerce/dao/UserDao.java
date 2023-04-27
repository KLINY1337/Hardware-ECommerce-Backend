package com.chernomurov.hardwareecommerce.dao;

import com.chernomurov.hardwareecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}
