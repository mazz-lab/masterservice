package org.mazz.masterservice.service;

import java.util.List;
import java.util.Optional;

import org.mazz.masterservice.entity.UserMasterEntity;
import org.mazz.masterservice.exception.ResourceNotFoundException;
import org.mazz.masterservice.repository.UserMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserMasterServiceImpl implements UserMasterService  {
	@Autowired
	private UserMasterRepository userMasterRepository;

	@Override
	public UserMasterEntity loginValidation(UserMasterEntity user) throws ResourceNotFoundException {
		
		 List<UserMasterEntity> uservalidation =
			        userMasterRepository
			            .getUserListByUserName(user.getUserName())
			            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + user.getUserName()));

		  
		  
		  UserMasterEntity validUser = uservalidation.stream() .filter(b -> b.getPassword().equalsIgnoreCase(user.getPassword())) .findFirst().orElseThrow(() -> new ResourceNotFoundException("Password is Incorrect "));

		return validUser;
	}

}
