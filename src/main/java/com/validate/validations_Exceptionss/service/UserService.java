package com.validate.validations_Exceptionss.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validate.validations_Exceptionss.entity.User;
import com.validate.validations_Exceptionss.exceptions.UserNotFoundException;
import com.validate.validations_Exceptionss.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User insert(@Valid User user) throws UserNotFoundException {
	   String email= user.getEmail();
	   if(userRepo.findByEmail(email)!=null) {
		   throw new UserNotFoundException("An Account has been already registered  with this email id:  " + email);
	   }
	   else {
		   return userRepo.save(user);
	   }
		

	}

	public User getById(long id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);

		System.out.println("userId");
		System.out.println(user.isPresent());
		User u = new User();
		if (user.isPresent() == false) {
			throw new UserNotFoundException("User Not found with given id " + id);

		} else {
			return u = user.get();
		}

	}

	public User updateById(long id, User user) throws UserNotFoundException {
		Optional<User> user1 = userRepo.findById(id);
		if (user1.isPresent() == false) {
			throw new UserNotFoundException("User Not found with given id to update the data" + id);

		} else {
			User u= user1.get();
			u.setName(user.getName());
			u.setAge(user.getAge());
			u.setGender(user.getGender());
			u.setNationality(user.getNationality());
			
			return userRepo.save(u);
		}

		
		
		
	}

	public String deleteById(long id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent() == false) {
			throw new UserNotFoundException("User Not found with given id " + id);

		} else {
			userRepo.deleteById(id);
			return "An Account has been deleted successfully";
		}

		
		
		
	}

}
