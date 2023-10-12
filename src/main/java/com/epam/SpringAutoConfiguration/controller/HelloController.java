package com.epam.SpringAutoConfiguration.controller;

import com.epam.SpringAutoConfiguration.service.HelloService;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @ReadOperation
    public String customActuatorEndpoint() {
        return helloService.sayHello();
    }

}
