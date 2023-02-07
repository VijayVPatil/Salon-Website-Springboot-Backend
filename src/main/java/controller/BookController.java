package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IBooking;
import model.Booking;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BookController {

	@Autowired
	IBooking booking;

	@GetMapping("/admin/viewAllBookings")
	public List<Booking> viewAllBookings() {
		for (Booking b : booking.findAll()) {
			System.out.println(b);
		}
		return booking.findAll();
	}

	@PostMapping("/addBooking")
	public String addBooking(@RequestBody Booking b) {
		booking.save(b);
		return "Booking added";
	}

}
