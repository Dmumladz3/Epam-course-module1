package com.epam.javacc.microservices.one.controller;

import com.epam.javacc.microservices.config.PropertyReader;
import com.epam.javacc.microservices.config.PropertyReaderImpl;
import com.epam.javacc.microservices.one.service.OneService;
import com.epam.javacc.microservices.one.service.TwoServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class OneController implements OneService {

    @Autowired
    private TwoServiceClient two;

    public OneController() {
    }

    @Autowired
    TwoServiceClient twoServiceClient;

    @Autowired
    PropertyReader propertyReader;

    @Override
    public String callService(@PathVariable("id") String id) {
        return "{one_call_two: " + twoServiceClient.getSomething1(id) + "}";
    }

    @Override
    public String callService2(@PathVariable("id") String id) {
        return "{one_call_two2: " + twoServiceClient.getSomething2(id) + "}";
    }

    @Override
    public String testProperty(@PathVariable("propertyName") String propertyName) {

        String result = propertyReader.getStringProperty(propertyName);
        return result;
    }

}
