package com.asakana.auth.auth_service;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions", schema = "auth")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perm_id")
    private Integer permId;

    @Column(name = "perm_name", nullable = false, unique = true)
    private String permName;

    @Column
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    // Getters and setters
    public Integer getPermId() { return permId; }
    public void setPermId(Integer permId) { this.permId = permId; }
    public String getPermName() { return permName; }
    public void setPermName(String permName) { this.permName = permName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
} 