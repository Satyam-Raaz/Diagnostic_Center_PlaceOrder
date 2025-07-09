package com.diagnostic.DiagnosticCenter.service;

import java.util.List;


import com.diagnostic.DiagnosticCenter.dto.BookingDetails;
import com.diagnostic.DiagnosticCenter.dto.BookingRequest;
import com.diagnostic.DiagnosticCenter.entity.Booking;

public interface BookingService {
	Booking addBooking(BookingRequest booking,int id);
	List<BookingDetails> getBooking(int id);
	List<BookingDetails> getAll();

}
