package com.tnsif.certifcate.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.tnsif.certifcate.model.Certificate;
import com.tnsif.certifcate.service.CertificateService;

@RestController
public class CertifcateController {

	@Autowired
	private CertificateService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/certificates")
	public List<Certificate> list() {
		return service.listAll();
	}

	@GetMapping("/certificates/{id}")
	public ResponseEntity<Certificate> get(@PathVariable Integer id) {
		try {
			Certificate certificate = service.get(id);
			return new ResponseEntity<Certificate>(certificate, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/certificates")
	public void add(@RequestBody Certificate certificate) {
		service.save(certificate);
	}

	// RESTful API method for Update operation
	@PutMapping("/certificates/{id}")
	public ResponseEntity<?> update(@RequestBody Certificate certificate, @PathVariable Integer id) {
		try {
			Certificate existProduct = service.get(id);
			service.save(certificate);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/certificates/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
