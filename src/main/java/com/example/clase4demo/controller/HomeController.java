package com.example.clase4demo.controller;

import com.example.clase4demo.entity.Employee;
import com.example.clase4demo.entity.OrderDetails;
import com.example.clase4demo.entity.Territory;
import com.example.clase4demo.repository.EmployeeRepository;
import com.example.clase4demo.repository.OrderDetailsRepository;
import com.example.clase4demo.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    TerritoryRepository territoryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @GetMapping("")
    public String index() {

        //List<Territory> listaTerritorios = territoryRepository.findAll();

        //List<Employee> listaEmpleados = employeeRepository.findAll();

        List<OrderDetails> orderDetailsList = orderDetailsRepository.findAll();

        return "index";
    }
}
