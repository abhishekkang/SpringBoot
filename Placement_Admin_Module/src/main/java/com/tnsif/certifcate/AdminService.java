package com.tnsif.certifcate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminRepository repo;

	public List<Admin> listAll() {
		return repo.findAll();
	}

	public void save(Admin admin) {
		repo.save(admin);
	}

	public Admin get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
