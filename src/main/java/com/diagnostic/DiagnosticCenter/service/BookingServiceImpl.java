package com.diagnostic.DiagnosticCenter.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	public Booking addBooking(BookingRequest requestBooking,int id){
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
			booking.setImageUrl(requestBooking.getImageUrl());
			booking.setSlot(dateTimeStr);
			booking.setUser_id(id);
			return repoBooking.save(booking);
		}
        else {
        	return null;
        }
	}

	@Override
	public List<BookingDetails> getAll() {
		List<BookingDetails> bookingDetails=new ArrayList<>();
		List<Booking> bookings=repoBooking.findAll();
		System.out.println("First error");
		for(Booking booking:bookings) {
			User user=userRepo.findById(booking.getUser_id()).get();
			System.out.println(user.getId());
			BookingDetails bookingDetail=new BookingDetails();
			bookingDetail.setCenterName(booking.getCenterName());
			bookingDetail.setTestName(booking.getTestName());
			bookingDetail.setSlot(booking.getSlot());
			bookingDetail.setUsername(user.getUsername());
			bookingDetail.setAddress(user.getAddress());
			bookingDetail.setContactNo(user.getContactNo());
			bookingDetails.add(bookingDetail);
		}
		System.out.println("Third error");

		return bookingDetails;
		
	}
	
	@Override
	public List<BookingDetails> getBooking(int id) {
		List<BookingDetails> bookingDetails=new ArrayList<>();
		User user=userRepo.findById(id).get();
		List<Booking> bookings=repoBooking.findByUserId(id);
		for(Booking booking:bookings) {
			BookingDetails bookingDetail=new BookingDetails();
			bookingDetail.setCenterName(booking.getCenterName());
			bookingDetail.setTestName(booking.getTestName());
			bookingDetail.setSlot(booking.getSlot());
			bookingDetail.setUsername(user.getUsername());
			bookingDetail.setAddress(user.getAddress());
			bookingDetail.setContactNo(user.getContactNo());
			bookingDetails.add(bookingDetail);
		}

		return bookingDetails;
		
	}
	
	

}
