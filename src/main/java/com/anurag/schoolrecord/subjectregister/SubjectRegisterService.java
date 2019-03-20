package com.anurag.schoolrecord.subjectregister;

import java.util.ArrayList;
import java.util.Optional;

import com.anurag.schoolrecord.entities.Subject;

public interface SubjectRegisterService {
	String addSubject(Subject subject);
	ArrayList<Subject> getAllSubjects();
	Optional<Subject> getSubjectByItsId(String subjectId);
	String removeSubject(String subjectId);
	String updateSubject(Subject subject);
}
