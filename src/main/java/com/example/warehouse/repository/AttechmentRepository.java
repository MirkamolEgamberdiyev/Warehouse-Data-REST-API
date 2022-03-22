package com.example.warehouse.repository;

import com.example.warehouse.entity.Attechment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "attechment")
public interface AttechmentRepository extends JpaRepository<Attechment, Integer> {
}