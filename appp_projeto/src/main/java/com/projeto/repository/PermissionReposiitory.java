package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Permission;

public interface PermissionReposiitory extends JpaRepository<Permission, Long> {

}
