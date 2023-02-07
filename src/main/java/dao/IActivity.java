package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Activity;

public interface IActivity extends JpaRepository<Activity, Integer> {

}
