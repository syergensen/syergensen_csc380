package service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * User: Sean Yergensen
 */
@WebService
public interface GreetingService {
    public String helloWorld(@WebParam(name="name") String name);
}