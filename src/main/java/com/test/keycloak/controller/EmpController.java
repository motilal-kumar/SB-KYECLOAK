package com.test.keycloak.controller;


import com.test.keycloak.model.Employee;
import com.test.keycloak.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpRepo empRepo;


    @PostMapping("/employees")
    @RolesAllowed("user")
    public ResponseEntity<Employee>  createEmp(@RequestBody  Employee employee){

        return ResponseEntity.ok(empRepo.save(employee));
    }



    @GetMapping("/employees")
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>>  getAllEmp(){

        return ResponseEntity.ok(empRepo.findAll());
    }
}
