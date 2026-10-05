package com.ra.patientservice.service.impl;

import com.ra.patientservice.dto.request.PatientRequestDTO;
import com.ra.patientservice.dto.response.PatientResponseDTO;
import com.ra.patientservice.entity.Patient;
import com.ra.patientservice.repository.PatientRepository;
import com.ra.patientservice.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO request) {
        Patient patient = Patient.builder()
                .fullName(request.getFullName())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .medicalHistory(request.getMedicalHistory())
                .build();

        Patient savedPatient = patientRepository.save(patient);

        return PatientResponseDTO.builder()
                .id(savedPatient.getId())
                .fullName(savedPatient.getFullName())
                .dateOfBirth(savedPatient.getDateOfBirth())
                .gender(savedPatient.getGender())
                .phoneNumber(savedPatient.getPhoneNumber())
                .address(savedPatient.getAddress())
                .medicalHistory(savedPatient.getMedicalHistory())
                .build();
    }
}