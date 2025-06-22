package com.asakana.auth.auth_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    boolean existsByPermName(String permName);
    Permission findByPermName(String permName);
} 