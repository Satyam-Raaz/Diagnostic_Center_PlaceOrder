package com.diagnostic.DiagnosticCenter.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diagnostic.DiagnosticCenter.dto.BookingDetails;
import com.diagnostic.DiagnosticCenter.dto.BookingRequest;
import com.diagnostic.DiagnosticCenter.entity.Booking;
import com.diagnostic.DiagnosticCenter.entity.Center;
import com.diagnostic.DiagnosticCenter.entity.Test;
import com.diagnostic.DiagnosticCenter.entity.User;
import com.diagnostic.DiagnosticCenter.repository.BookingRepository;
import com.diagnostic.DiagnosticCenter.repository.TestRepository;
import com.diagnostic.DiagnosticCenter.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository repoBooking;
	
	@Autowired
	TestRepository testRepo;
	
	@Autowired
	CenterServiceImpl centerService;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Booking addBooking(BookingRequest requestBooking,int id) {
		Booking booking=new Booking();
		Center center=centerService.getCenterByName(requestBooking.getCenterName());
		List<Test> tests=center.getTests();
		Test test2=new Test();
		for(Test test:tests) {
			if(test.getName().equals(requestBooking.getTestName())) {
				test2=test;
				break;
			}
		}
        if (test2.getSeats()>0) {
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			date.plusDays(5);
			time.plusHours(8);
			LocalDateTime dateTime = LocalDateTime.of(date, time);
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			// Convert to strings
			String dateTimeStr = dateTime.format(dateTimeFormatter);
			booking.setTestName(requestBooking.getTestName());
			booking.setCenterName(requestBooking.getCenterName());
			booking.setSlot(dateTimeStr);
			booking.setUser_id(id);
			return repoBooking.save(booking);
		}
        else {
        	return null;
        }
	}

	@Override
	public List<Booking> getAll() {
		return  repoBooking.findAll();
	}
	
	@Override
	public BookingDetails getBooking(int id) {
		BookingDetails bookingDetails=new BookingDetails();
		User user=userRepo.findById(id).get();
		Booking booking=repoBooking.findByUserId(id);
		bookingDetails.setCenterName(booking.getCenterName());
		bookingDetails.setTestName(booking.getTestName());
		bookingDetails.setSlot(booking.getSlot());
		bookingDetails.setUsername(user.getUsername());
		bookingDetails.setAddress(user.getAddress());
		bookingDetails.setContactNo(user.getContactNo());
		return bookingDetails;
		
	}

}
