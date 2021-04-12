package com.example.clase4demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.clase4demo.entity.Shipper;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

    List<Shipper> findByCompanyName(String nombre);

    @Query(value = "select * from shippers where CompanyName = ?1",
            nativeQuery = true)
    List<Shipper> buscarTransPorCompName(String nombre);


}

