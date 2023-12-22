package com.example.examprotable.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Role {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    private String roleName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

}
