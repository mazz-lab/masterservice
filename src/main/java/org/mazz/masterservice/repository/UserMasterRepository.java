package org.mazz.masterservice.repository;

import java.util.List;
import java.util.Optional;

import org.mazz.masterservice.entity.UserMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMasterEntity, Long> {
	
	 @Query("FROM UserMasterEntity t where t.userName = :userName")     
	Optional<List<UserMasterEntity>> getUserListByUserName( @Param("userName") String userName);
	
}