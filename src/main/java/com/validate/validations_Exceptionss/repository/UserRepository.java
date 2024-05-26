package com.validate.validations_Exceptionss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validate.validations_Exceptionss.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
