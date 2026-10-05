package com.ra.patientservice.controller;

import com.ra.patientservice.dto.request.PatientRequestDTO;
import com.ra.patientservice.dto.response.PatientResponseDTO;
import com.ra.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO request) {
        return new ResponseEntity<>(patientService.createPatient(request), HttpStatus.CREATED);
    }
}