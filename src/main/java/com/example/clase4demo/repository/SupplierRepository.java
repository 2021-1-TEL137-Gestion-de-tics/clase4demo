package com.example.clase4demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.clase4demo.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
