package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.DiagnosticCenter;
import com.example.service.ServiceClass;


@RestController
@RequestMapping("diagnostic")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
@Autowired
ServiceClass serviceobj;
@PostMapping("/DiagnosticCenterCreation")
public ResponseEntity<String> DiagnosticCenterCreation(@RequestBody DiagnosticCenter dia) {
	DiagnosticCenter d = serviceobj.DiagnosticCenterCreation(dia);
	if (d == null) {
		throw new com.example.exception.IdNotFoundException("Enter Valid Id");
	} else {
		return new ResponseEntity<String>("DianosticCenter created sucessfully", new HttpHeaders(), HttpStatus.OK);
	}
}
//Get Particular Employee Data
	@GetMapping("/GetDiagnosticCenter/{id}")
	private ResponseEntity<DiagnosticCenter> getEmployee(@PathVariable("id") int id) {
		DiagnosticCenter d = serviceobj.getDiagnosticCenterById(id);
		if (d == null) {
			throw new com.example.exception.IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<DiagnosticCenter>(d, new HttpHeaders(), HttpStatus.OK);
		}
	}
	@GetMapping("/GetAllDiagnosticCenter")
	private ResponseEntity<List<DiagnosticCenter>> getAllEmployee() {
		List<DiagnosticCenter> emplist = serviceobj.getAllDiagnosticCenter();
		return new ResponseEntity<List<DiagnosticCenter>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}
	@PutMapping("/UpdateDiagnosticCenter")
	public ResponseEntity<String> UpdateEmployee(@RequestBody DiagnosticCenter emp) {
		DiagnosticCenter d = serviceobj.UpdateDiagnosticCenter(emp);
		if (d == null) {
			throw new com.example.exception.IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("DianosticCenter updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	@DeleteMapping("/DeleteEmployee/{id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int id) {
		DiagnosticCenter d = serviceobj.delete(id);
		if (d == null) {
			throw new com.example.exception.IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("DianosticCenter deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	@ExceptionHandler(com.example.exception.IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(com.example.exception.IdNotFoundException d) {
		return new ResponseEntity<String>(d.getMessage(), HttpStatus.NOT_FOUND);
	}

}
