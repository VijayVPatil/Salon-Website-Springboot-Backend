package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.User;

public interface IUser extends JpaRepository<User, String> {


	@Query(value = "SELECT * from user where username=?", nativeQuery = true)
	public User findDetailsByUsername(String username);
}
