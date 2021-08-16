package com.manhcode.rest.jaxrs.injection.service;

import com.manhcode.rest.jaxrs.injection.entity.Passenger;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

@Service
public class PassengerServiceImpl implements PassengerService{
    private Map<Integer, Passenger> passengers = new HashMap<>();
    private int currentId = 1;

    public PassengerServiceImpl() {
        init();
    }

    private void init() {
        passengers.put(currentId, new Passenger(currentId++, "Manh"));
        passengers.put(currentId, new Passenger(currentId++, "Phong"));
        passengers.put(currentId, new Passenger(currentId++, "Lan"));
    }
    @Override
    public List<Passenger> findAll(int start, int size) {
        System.out.println(start+"  :   "+size);
        Collection<Passenger> results = passengers.values();
        List<Passenger> response = new ArrayList<>(results);
        return response;
    }

    @Override
    public Passenger save(Passenger passenger) {
        passenger.setId(currentId++);
        passengers.put(passenger.getId(), passenger);
        return passenger;
    }

    @Override
    public Passenger save2(String firstName, String lastName) {
        Passenger newPass = new Passenger();
        newPass.setId(currentId++);
        newPass.setName(firstName+" "+lastName);
        passengers.put(newPass.getId(), newPass);
        return newPass;
    }

    @Override
    public void testContext(HttpHeaders headers) {

        MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
        Set<String> headerKeys = allHeaders.keySet();
        for(String key : headerKeys) {
            System.out.print(key+" : ");
            System.out.println(headers.getHeaderString(key));
        }
        System.out.println("------------------------------------------");
        Map<String, Cookie> cookies = headers.getCookies();
        Set<String> cookieKeys = cookies.keySet();
        for(String key : cookieKeys) {
            System.out.println("--------------------Cookie----------------------");
            System.out.print(key+" : ");
            System.out.println(cookies.get(key));
        }
    }

    @Override
    public Passenger save3(String agent, Passenger passenger) {
        System.out.println(agent);
        passenger.setId(currentId++);
        passengers.put(passenger.getId(), passenger);
        return passenger;
    }
}
