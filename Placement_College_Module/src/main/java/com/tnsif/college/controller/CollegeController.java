package com.tnsif.college.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.tnsif.college.model.College;
import com.tnsif.college.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/colleges")
	public List<College> list() {
		return service.listAll();
	}

	@GetMapping("/colleges/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id) {
		try {
			College college = service.get(id);
			return new ResponseEntity<College>(college, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/colleges")
	public void add(@RequestBody College student) {
		service.save(student);
	}

	// RESTful API method for Update operation
	@PutMapping("/colleges/{id}")
	public ResponseEntity<?> update(@RequestBody College college, @PathVariable Integer id) {
		try {
			College existProduct = service.get(id);
			service.save(college);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/colleges/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}