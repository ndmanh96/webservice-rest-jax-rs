package com.manhcode.rest.jaxrs6.springrestjaxrs.service;

import com.manhcode.rest.jaxrs6.springrestjaxrs.entity.Patient;
import com.manhcode.rest.jaxrs6.springrestjaxrs.exceptionhandler.PatientBussinessException;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {
    private Map<Integer, Patient> patients = new HashMap<>();
    private int currentId = 1;

    public PatientServiceImpl() {
        init();
    }

    private void init() {
        patients.put(currentId, new Patient(currentId++, "Manh"));
        patients.put(currentId, new Patient(currentId++, "Phong"));
        patients.put(currentId, new Patient(currentId++, "Lan"));
    }

    @Override
    public List<Patient> findAll() {
        System.out.println(patients);
        Collection<Patient> results = patients.values();
        List<Patient> reponse = new ArrayList<>(results);
        return reponse;
    }

    @Override
    public Patient findById(int id) {
        Patient patient = patients.get(id);
        if(patient == null) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
            throw new NotFoundException();
        }

        return patients.get(id);
    }

    @Override
    public Response save(Patient patient) {
        patient.setId(currentId++);
        patients.put(patient.getId(), patient);
        return Response.ok(patient).build();
    }

    @Override
    public Response update(Patient patient) {
        Patient currentPatient = patients.get(patient.getId());
        Response response;
        if (currentPatient != null) {
            patients.put(patient.getId(), patient);
            response = Response.ok(patient).build();
        } else {
            response = Response.notModified().build();
        }
        return response;
    }

    @Override
    public Response deleteById(int id) {
        Patient patient = patients.get(id);
        Response response;
        if (patient != null) {
            patients.remove(id);
            response = Response.ok().build();
        } else {
            throw new PatientBussinessException();
        }
        return response;
    }
}
