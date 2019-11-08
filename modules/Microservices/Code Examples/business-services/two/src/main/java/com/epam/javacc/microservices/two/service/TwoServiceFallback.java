package com.epam.javacc.microservices.two.service;

import com.epam.javacc.microservices.two.TwoServiceAPI;
import org.springframework.web.bind.annotation.PathVariable;

public class TwoServiceFallback implements TwoServiceAPI {

    @Override
    public String getSomething1(@PathVariable("id") String customerId) {
        throw new RuntimeException("Two service is unreachable");
    }

    @Override
    public String getSomething2(@PathVariable("id") String customerId) {
        throw new RuntimeException("Two service is unreachable");
    }
}
