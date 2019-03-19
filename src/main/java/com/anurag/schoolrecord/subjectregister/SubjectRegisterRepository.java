package com.anurag.schoolrecord.subjectregister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.schoolrecord.database_entities.Subject;

public interface SubjectRegisterRepository extends JpaRepository<Subject, String>{

}
