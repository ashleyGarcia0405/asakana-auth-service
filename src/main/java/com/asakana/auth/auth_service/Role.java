package com.asakana.auth.auth_service;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "auth")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @Column
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "role_permissions",
        schema = "auth",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "perm_id")
    )
    private Set<Permission> permissions = new HashSet<>();

    // Getters and setters
    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<User> getUsers() { return users; }
    public void setUsers(Set<User> users) { this.users = users; }
    public Set<Permission> getPermissions() { return permissions; }
    public void setPermissions(Set<Permission> permissions) { this.permissions = permissions; }
} 