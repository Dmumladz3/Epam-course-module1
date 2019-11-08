package com.epam.javacc.microservices.one.service;


import com.epam.javacc.microservices.two.TwoServiceAPI;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "two")
public interface TwoServiceClient extends TwoServiceAPI {
}
