package com.tnsif.certifcate;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
	@Autowired
	private AdminService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/admins")
	public List<Admin> list() {
		return service.listAll();
	}

	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id) {
		try {
			Admin admin = service.get(id);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/admins")
	public void add(@RequestBody Admin admin) {
		service.save(admin);
	}

	// RESTful API method for Update operation
	@PutMapping("/admins/{id}")
	public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Integer id) {
		try {
			Admin existProduct = service.get(id);
			service.save(admin);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/admins/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
