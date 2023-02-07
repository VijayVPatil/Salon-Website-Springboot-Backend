package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IUser;
import model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	@Autowired
	IUser userL;

	@PostMapping("/signup")
	public String userSignup(@RequestBody User b) {
		userL.save(b);
		return "Signed Up";
	}

	@GetMapping("/login/{username}/{password}")
	public String userLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
		if (userL.findById(username).isPresent()) {
			if (userL.findById(username).get().getPassword().equals(password)) {
				return "true";
			} else {
				return "false";
			}
		}
		return "false";
	}

	@GetMapping("/admin/viewRegisteredUsers")
	public List<User> viewRegisteredUsers() {
		return userL.findAll();
	}

	@PutMapping("/updateUserPassword/{username}")
	public String updateUserPassword(@RequestBody User u, @PathVariable("username") String username) {
		userL.findById(username).map(update -> {
			update.setPassword(u.getPassword());
			return userL.save(update);
		});
		return "Password Updated";
	}
	@GetMapping("/userProfile/{username}")
	public User getUserProfile(@PathVariable("username") String username) {
		User u = userL.findDetailsByUsername(username);
		return u;
	}
}
