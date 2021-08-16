package com.manhcode.rest.jaxrs.security.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {
    private int id;
    private String description;

    public Product() {}

    public Product(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
