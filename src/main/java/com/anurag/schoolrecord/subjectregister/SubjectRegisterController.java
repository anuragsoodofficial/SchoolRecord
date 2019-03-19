package com.anurag.schoolrecord.subjectregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.Subject;

@RestController
public class SubjectRegisterController {
	
	@Autowired
	private SubjectRegisterService subjectRegisterService;
	
	//Get all subjects
	@RequestMapping("/subjects")
	public ArrayList<Subject> getAllSubjects(){
		return subjectRegisterService.getAllSubjects();
	}
	
	//Add a subject
	@RequestMapping(method = RequestMethod.POST, value= "/subjects")
	public void addSubject(@RequestBody Subject subject) {
		subjectRegisterService.addSubject(subject);
	}
	
	//Get a subject by its Id
	@RequestMapping("/subjects/get")
	public Optional<Subject> getSubjectById(@RequestParam(name = "subjectId",defaultValue="Unknown") String subjectId){
		return subjectRegisterService.getSubjectByItsId(subjectId);
	}
	
	//Delete a subject
	@RequestMapping(method=RequestMethod.DELETE,value="/subjects")
	public void removeSubject(@RequestParam(name = "subjectId",defaultValue="Unknown") String subjectId) {
		subjectRegisterService.removeSubject(subjectId);
	}
}
