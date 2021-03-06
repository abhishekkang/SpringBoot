package com.tnsif.student;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repo;
	public List<Student> listAll()
	{
	return repo.findAll();
	}
	public void save(Student student)
	{
	repo.save(student);
	}
	public Student get(Integer id)
	{
	return repo.findById(id).get();
	}
	public void delete(Integer id)
	{
	repo.deleteById(id);
	}
	}

