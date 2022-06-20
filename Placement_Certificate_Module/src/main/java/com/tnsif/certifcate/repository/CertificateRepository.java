package com.tnsif.certifcate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.certifcate.model.Certificate;


public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
	

}
