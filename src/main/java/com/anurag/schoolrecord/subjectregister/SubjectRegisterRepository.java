package com.anurag.schoolrecord.subjectregister;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anurag.schoolrecord.entities.Subject;

@Repository
public interface SubjectRegisterRepository extends JpaRepository<Subject, String>{

}
