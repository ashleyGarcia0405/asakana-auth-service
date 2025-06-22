package com.asakana.auth.auth_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Optional<Permission> getPermissionById(Integer id) {
        return permissionRepository.findById(id);
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission updatePermission(Integer id, Permission permissionDetails) {
        return permissionRepository.findById(id).map(permission -> {
            permission.setPermName(permissionDetails.getPermName());
            permission.setDescription(permissionDetails.getDescription());
            return permissionRepository.save(permission);
        }).orElseThrow(() -> new RuntimeException("Permission not found"));
    }

    public void deletePermission(Integer id) {
        permissionRepository.deleteById(id);
    }
} 