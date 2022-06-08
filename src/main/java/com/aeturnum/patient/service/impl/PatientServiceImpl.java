package com.aeturnum.patient.service.impl;

import com.aeturnum.patient.dao.Patient;
import com.aeturnum.patient.repository.PatientRepository;
import com.aeturnum.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            log.info(String.format("Patient Id: %s not found", id));
            return null;
        }
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Optional<Patient> optionalPatient = patientRepository.findById(patient.getId());
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setFirstName(patient.getFirstName());
            existingPatient.setLastName(patient.getLastName());
            existingPatient.setEmail(patient.getEmail());
            existingPatient.setAddress(patient.getAddress());
            existingPatient.setCity(patient.getCity());
            existingPatient.setState(patient.getState());
            existingPatient.setZipCode(patient.getZipCode());
            existingPatient.setPhoneNumber(patient.getPhoneNumber());
            return patientRepository.save(existingPatient);
        }
        log.info(String.format("Patient Id: %s not found", patient.getId()));
        return null;
    }

    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
