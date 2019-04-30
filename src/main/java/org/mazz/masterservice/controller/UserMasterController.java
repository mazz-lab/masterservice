package org.mazz.masterservice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.mazz.masterservice.entity.UserMasterEntity;
import org.mazz.masterservice.exception.ResourceNotFoundException;
import org.mazz.masterservice.repository.UserMasterRepository;
import org.mazz.masterservice.service.UserMasterService;
import org.mazz.masterservice.service.UserMasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserMasterController {
  @Autowired
  private UserMasterRepository userMasterRepository;
  
  
  @Autowired
  private  UserMasterService userMasterService;
  
  
  
  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("")
  public List<UserMasterEntity> getAllUsers() {
    return userMasterRepository.findAll();
  }
  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserMasterEntity> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
	  UserMasterEntity user =
        userMasterRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }
  
  
  @PostMapping("/valid")
  public ResponseEntity<UserMasterEntity> userValidation( @RequestBody UserMasterEntity user) throws ResourceNotFoundException {
	  
	  UserMasterEntity validUser =
			  userMasterService.loginValidation(user);
		    return ResponseEntity.ok(validUser);
  }
  
  
 
  
  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("")
  public UserMasterEntity createUser(@Valid @RequestBody UserMasterEntity user) {
    return userMasterRepository.save(user);
  }
  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/{id}")
  public ResponseEntity<UserMasterEntity> updateUser(
      @PathVariable(value = "id") Long userId, @Valid @RequestBody UserMasterEntity userDetails)
      throws ResourceNotFoundException {
	  UserMasterEntity user =
        userMasterRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    user.setUpdatedAt(new Date());
    final UserMasterEntity updatedUser = userMasterRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }
  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
	  UserMasterEntity user =
        userMasterRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    userMasterRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}