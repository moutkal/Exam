package com.example.examprotable.repository;

import com.example.examprotable.entities.Role;
import com.example.examprotable.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
