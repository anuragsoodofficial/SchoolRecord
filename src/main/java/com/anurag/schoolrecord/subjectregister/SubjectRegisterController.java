package com.anurag.schoolrecord.subjectregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.entities.Subject;

@RestController
public class SubjectRegisterController {
	
	@Autowired
	private SubjectRegisterServiceImpl subjectRegisterServiceImpl;
	
	//Get all subjects
	@GetMapping("/subjects")
	public ArrayList<Subject> getAllSubjects(){
		return subjectRegisterServiceImpl.getAllSubjects();
	}
	
	//Add a subject
	@PostMapping("/subjects")
	public String addSubject(@RequestBody Subject subject) {
		subjectRegisterServiceImpl.addSubject(subject);
		return "Added Successfully";
	}
	
	//Get a subject by its Id
	@GetMapping("/subjects/get")
	public Optional<Subject> getSubjectById(@RequestParam(name = "subjectId",defaultValue="Unknown") String subjectId){
		return subjectRegisterServiceImpl.getSubjectByItsId(subjectId);
	}
	
	//Delete a subject
	@DeleteMapping("/subjects")
	public String removeSubject(@RequestParam(name = "subjectId",defaultValue="Unknown") String subjectId) {
		subjectRegisterServiceImpl.removeSubject(subjectId);
		return "Removed Successfully";
	}
	
	//Update a subject
	@PutMapping("/subjects")
	public String updateSubject(@RequestBody Subject subject) {
		subjectRegisterServiceImpl.updateSubject(subject);
		return "Updated Successfully";
	}
}
