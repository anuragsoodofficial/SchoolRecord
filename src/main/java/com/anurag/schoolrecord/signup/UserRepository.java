package com.anurag.schoolrecord.signup;


import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.schoolrecord.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
