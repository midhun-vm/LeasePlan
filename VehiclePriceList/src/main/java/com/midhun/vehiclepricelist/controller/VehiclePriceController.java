package com.midhun.vehiclepricelist.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midhun.vehiclepricelist.entities.VehiclePrice;
import com.midhun.vehiclepricelist.repos.VehiclePriceRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VehiclePriceController {

	@Autowired
	VehiclePriceRepository vehiclePriceRepo; // Dependency Injection

	/*
	 * Description : Rest API service for retrieving all vehicle price list Return
	 * Type : ResponseEntity<List<VehiclePrice>> Method : GET
	 * 
	 */
	@GetMapping("/priceList")
	public ResponseEntity<List<VehiclePrice>> getAllPriceList() {
		try {
			List<VehiclePrice> vehicles = new ArrayList<VehiclePrice>();

			vehiclePriceRepo.findAll().forEach(vehicles::add);

			if (vehicles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(vehicles, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Description : Rest API service for creating a vehicle entry Return Type :
	 * ResponseEntity<VehiclePrice> Method : POST
	 * 
	 */
	@PostMapping("/createPriceList")
	public ResponseEntity<VehiclePrice> createTutorial(@RequestBody VehiclePrice vehiclePrice) {
		try {
			VehiclePrice vehicle = new VehiclePrice();
			vehicle.setMakeName(vehiclePrice.getMakeName());
			vehicle.setModelName(vehiclePrice.getModelName());
			vehicle.setPrice(vehiclePrice.getPrice());
			vehicle.setOptionName(vehiclePrice.getOptionName());
			vehicle.setOptionPrice(vehiclePrice.getOptionPrice());
			VehiclePrice response = vehiclePriceRepo.save(vehicle);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	/*
	 * Description : Rest API service for updating a vehicle entry Return Type :
	 * ResponseEntity<VehiclePrice> Method : POST
	 * 
	 */
	@PostMapping("/updatePriceList/{id}")
	public ResponseEntity<VehiclePrice> updatePriceList(@PathVariable("id") Integer id,
			@RequestBody VehiclePrice vehiclePrice) {
		Optional<VehiclePrice> vehicleData = vehiclePriceRepo.findById(id);

		if (vehicleData.isPresent()) {
			VehiclePrice vehicle = vehicleData.get();
			vehicle.setMakeName(vehiclePrice.getMakeName());
			vehicle.setModelName(vehiclePrice.getModelName());
			vehicle.setPrice(vehiclePrice.getPrice());
			vehicle.setOptionName(vehiclePrice.getOptionName());
			vehicle.setOptionPrice(vehiclePrice.getOptionPrice());
			return new ResponseEntity<>(vehiclePriceRepo.save(vehicle), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * Description : Rest API service for deleting a vehicle entry Return Type :
	 * ResponseEntity<HttpStatus> Method : DELETE
	 * 
	 */
	@DeleteMapping("/priceList/delete/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
		try {
			vehiclePriceRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
