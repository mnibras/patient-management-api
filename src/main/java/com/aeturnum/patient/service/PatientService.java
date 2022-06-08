package com.aeturnum.patient.service;

import com.aeturnum.patient.dao.Patient;
import com.aeturnum.patient.exception.PatientNotFoundException;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(int id) throws PatientNotFoundException;

    Patient savePatient(Patient patient);

    Patient updatePatient(Patient patient);

    void deletePatient(int id);

}
