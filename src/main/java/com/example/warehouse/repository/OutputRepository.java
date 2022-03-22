package com.example.warehouse.repository;

import com.example.warehouse.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "output")
public interface OutputRepository extends JpaRepository<Output, Integer> {
}