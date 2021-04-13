package com.example.clase4demo.repository;

import com.example.clase4demo.entity.OrderDetails;
import com.example.clase4demo.entity.OrderDetailsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsKey> {


}
