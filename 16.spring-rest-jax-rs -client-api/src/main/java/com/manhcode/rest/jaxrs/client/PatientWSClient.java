package com.manhcode.rest.jaxrs.client;

import com.manhcode.rest.jaxrs.client.dto.Patient;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class PatientWSClient {
    public static void main(String[] args) {
        deleteById(2);
    }

    public static void findById(int id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/patientservice/patients/"+id);
        Invocation.Builder request = target.request();
//        Response response = request.get();
//        System.out.println(response.getStatus());
        Patient patient = request.get(Patient.class);
        System.out.println(patient);
        client.close();
    }

    public static void findAll() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/patientservice/patients");
        Invocation.Builder request = target.request();
        List<Patient> list = request.get(new GenericType<List<Patient>>() {});
        System.out.println(list);
        client.close();
    }

    public static void update() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/patientservice/patients");

        Patient newPatient = new Patient(1, "Manh 2222");

        Response response = target.request().put(Entity.entity(newPatient, MediaType.APPLICATION_XML_TYPE));

        System.out.println(response.getStatus());
        response.close();
        client.close();

    }

    public static void createPatient() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/patientservice/patients");
        Patient newPatient = new Patient();
        newPatient.setName("Hehehe");

        Patient patient = target.request().post(Entity.entity(newPatient,MediaType.APPLICATION_XML_TYPE), Patient.class);
        System.out.println(patient);
        client.close();
    }

    public static void deleteById(int id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/patientservice/patients/"+id);

        Response response = target.request().delete();

        System.out.println(response.getStatus());
    }
}
