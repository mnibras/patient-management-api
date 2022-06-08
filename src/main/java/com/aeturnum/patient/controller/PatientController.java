package com.aeturnum.patient.controller;

import com.aeturnum.patient.dao.Patient;
import com.aeturnum.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping()
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") int id) {
        return patientService.getPatientById(id);
    }

    @PutMapping()
    public Patient updatePatient(@RequestBody Patient updatedPatient) {
        return patientService.updatePatient(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable("id") int id) {
        patientService.deletePatient(id);
    }

}
