package com.anurag.schoolrecord.studentregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRegisterServices {
	
	@Autowired
	private StudentRepository studentRepository;
}
