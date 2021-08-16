package com.manhcode.rest.jaxrs.injection.entity;

public class Passenger {
    private int id;
    private String name;

    public Passenger() {
    }

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
