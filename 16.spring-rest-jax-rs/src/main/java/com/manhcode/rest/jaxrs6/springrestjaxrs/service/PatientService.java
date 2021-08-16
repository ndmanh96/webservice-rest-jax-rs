package com.manhcode.rest.jaxrs6.springrestjaxrs.service;

import com.manhcode.rest.jaxrs6.springrestjaxrs.entity.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
// http://localhost:8080/services/patientservice/patients need add prefix services
@Path(value = "/patientservice")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface PatientService {
    @GET
    @Path(value = "/patients")
    public List<Patient> findAll();

    @GET
    @Path(value = "/patients/{id}")
    public Patient findById(@PathParam(value = "id") int id);

    @POST
    @Path(value = "/patients")
    public Response save(Patient patient);

    @PUT
    @Path(value = "/patients")
    public Response update(Patient patient);

    @DELETE
    @Path(value = "/patients/{id}")
    public Response deleteById(@PathParam(value = "id") int id);
}
