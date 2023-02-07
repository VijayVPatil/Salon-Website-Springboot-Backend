package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dao.IAdmin;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {

	@Autowired
	IAdmin adminL;

	@GetMapping("admin/login/{username}/{password}")
	public String userLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
		if (adminL.findById(username).isPresent()) {
			if (adminL.findById(username).get().getPassword().equals(password)) {
				return "true";
			} else {
				return "false";
			}
		}
		return "false";
	}
}
