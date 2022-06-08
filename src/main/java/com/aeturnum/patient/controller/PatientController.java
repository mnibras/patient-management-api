package com.aeturnum.patient.controller;

import com.aeturnum.patient.dao.Patient;
import com.aeturnum.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
        }
        catch (Exception ex) {
            log.error("Exception while retrieve all the patients: {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        try {
            return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Exception while save a patient : {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Exception while retrieve a patient: {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient updatedPatient) {
        try {
            return new ResponseEntity<>(patientService.updatePatient(updatedPatient), HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Exception while update a patient: {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePatient(@PathVariable("id") int id) {
        try {
            patientService.deletePatient(id);
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Exception while delete a patient: {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
