package com.ra.patientservice.service;

import com.ra.patientservice.dto.request.PatientRequestDTO;
import com.ra.patientservice.dto.response.PatientResponseDTO;

public interface PatientService {
    PatientResponseDTO createPatient(PatientRequestDTO request);
}