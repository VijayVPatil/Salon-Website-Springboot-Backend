package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IActivity;
import model.Activity;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ActivityController {

	@Autowired
	IActivity service;

	@GetMapping("/viewService")
	public List<Activity> viewService() {
		return service.findAll();
	}

	@DeleteMapping("admin/deleteService/{serviceId}")
	public List<Activity> deleteService(@PathVariable("serviceId") int serviceId) {
		service.deleteById(serviceId);
		return service.findAll();
		// return "Service Deleted";
	}

	@PostMapping("admin/addService")
	public String addService(@RequestBody Activity b) {
		service.save(b);
		return "Service added";
	}

	@PutMapping("admin/updateService/{serviceId}")
	public String updateServiceById(@RequestBody Activity b, @PathVariable("serviceId") int serviceId) {
		service.findById(serviceId).map(update -> {
			update.setServiceName(b.getServiceName());
			update.setServicePrice(b.getServicePrice());
			return service.save(update);
		});
		return "Service Updated";
	}

	@PutMapping("admin/updateAllService")
	public String updateAllService(@RequestBody Activity b) {
		service.findById(b.getServiceId()).map(update -> {
			update.setServiceName(b.getServiceName());
			update.setServicePrice(b.getServicePrice());
			return service.save(update);
		});
		return "Service Updated";
	}
}
