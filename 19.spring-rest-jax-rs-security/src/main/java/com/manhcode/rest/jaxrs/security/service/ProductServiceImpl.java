package com.manhcode.rest.jaxrs.security.service;

import com.manhcode.rest.jaxrs.security.entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{
    private Map<Integer, Product> products = new HashMap<>();
    private int currentId = 1;

    public ProductServiceImpl() {
        init();
    }

    private void init() {
        products.put(currentId, new Product(currentId++, "Manh"));
        products.put(currentId, new Product(currentId++, "Phong"));
        products.put(currentId, new Product(currentId++, "Lan"));
    }
    @Override
    public List<Product> findAll() {
        Collection<Product> results = products.values();
        List<Product> response = new ArrayList<>(results);
        return response;
    }

    @Override
    public Product save(Product product) {
        product.setId(currentId++);
        products.put(product.getId(), product);
        return product;
    }
}
