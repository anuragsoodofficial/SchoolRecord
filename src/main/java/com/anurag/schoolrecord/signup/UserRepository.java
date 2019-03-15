package com.anurag.schoolrecord.signup;

import org.springframework.data.repository.CrudRepository;

import com.anurag.schoolrecord.database_entities.User;

public interface UserRepository extends CrudRepository<User, String> {

}
