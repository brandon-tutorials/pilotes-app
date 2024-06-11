package com.pilotes.pilotes_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilotes.pilotes_app.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
	
	List<User> findByNameContaining(String name);
	
	List<User> findByNameStartsWith(String name);

}
