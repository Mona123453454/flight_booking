package com.reservation.airline.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.airline.entity.AirlineInfo;

@Repository
public interface AirlineInfoDao extends JpaRepository<AirlineInfo, Long>{
	
	AirlineInfo findByNameOfAirline(String name);

}
