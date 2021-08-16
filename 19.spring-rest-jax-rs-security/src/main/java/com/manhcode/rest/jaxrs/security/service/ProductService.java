package com.manhcode.rest.jaxrs.security.service;

import com.manhcode.rest.jaxrs.security.entity.Product;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/product-api")
public interface ProductService {
    @GET
    @Path("/products")
    public List<Product> findAll();
    @POST
    @Path("/products")
    public Product save(Product product);
}
