package com.diagnostic.DiagnosticCenter.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnostic.DiagnosticCenter.dto.BookingDetails;
import com.diagnostic.DiagnosticCenter.dto.BookingRequest;
import com.diagnostic.DiagnosticCenter.entity.Booking;
import com.diagnostic.DiagnosticCenter.entity.Center;
import com.diagnostic.DiagnosticCenter.service.BookingServiceImpl;
import com.diagnostic.DiagnosticCenter.service.CenterServiceImpl;


@RestController
@RequestMapping("/diagnostic/user")
public class UserController {

	
	@Autowired
	private CenterServiceImpl centerService;
	
	@Autowired
	private BookingServiceImpl bookingService;
	
	@GetMapping("/getAllCenter")
	public ResponseEntity<List<Center>> getAll(){
		try {
			return new ResponseEntity<>(centerService.getAll(),HttpStatus.OK);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	

	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<Center>> getCenterByTest(@PathVariable String name){
		return new ResponseEntity<>(centerService.getCenterByTest(name),HttpStatus.OK);
	}
	
	@PostMapping("/booking/{id}")
	public ResponseEntity<Booking> addBooking(@RequestBody BookingRequest booking ,@PathVariable int id) {
		return new ResponseEntity<>(bookingService.addBooking(booking,id),HttpStatus.OK);
	}
	
	@GetMapping("/getBookingDetails/{id}")
	public ResponseEntity<BookingDetails> getBookingDetails(@PathVariable int id) {
		return new ResponseEntity<>(bookingService.getBooking(id),HttpStatus.OK);
	}
	
}
