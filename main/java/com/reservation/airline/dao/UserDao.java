package com.reservation.airline.dao;

import com.reservation.airline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

}
