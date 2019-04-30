package org.mazz.masterservice.service;

import java.util.Optional;

import org.mazz.masterservice.entity.UserMasterEntity;
import org.mazz.masterservice.exception.ResourceNotFoundException;

public interface UserMasterService {
	
	UserMasterEntity loginValidation (UserMasterEntity userMasterEntity) throws ResourceNotFoundException;

}
