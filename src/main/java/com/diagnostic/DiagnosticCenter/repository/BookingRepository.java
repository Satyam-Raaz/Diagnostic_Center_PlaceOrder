package com.diagnostic.DiagnosticCenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diagnostic.DiagnosticCenter.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
	List<Booking> findByUserId(int id);

}
