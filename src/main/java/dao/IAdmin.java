package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Admin;

public interface IAdmin extends JpaRepository<Admin, String> {

	@Query(value = "SELECT * FROM admin WHERE username=?", nativeQuery = true)
	public Admin findByUserName(String username);

	@Query(value = "SELECT * FROM admin WHERE password=?", nativeQuery = true)
	public Admin findByPassword(String password);
}
