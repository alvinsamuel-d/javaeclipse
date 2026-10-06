package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Productidentity;
import com.example.demo.repository.Productrepo;

@RestController
public class Productcontroller {
@Autowired
public Productrepo repo;

@GetMapping("/getproduct")
public List <Productidentity> getproduct() {
	try {
		
		return repo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
	return null;
}

@DeleteMapping("/deleteproduct/{id}")
public String deleteproduct(@PathVariable int id) {
	try {
		Productidentity pro = repo.getOne(id);
		repo.delete(pro);
		return "product deleted sucessfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
	return null;
}
}
