package service;

import javax.jws.WebService;

/**
 * User: Sean Yergensen
 */
@WebService(endpointInterface = "service.GreetingService", serviceName = "GreetingService")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String helloWorld(String name) {
        return "Hello World, " + name + "!";
    }
}
