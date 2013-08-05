package service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Sean Yergensen
 */
@WebService(serviceName = "ZipCodeService", targetNamespace = "http://localhost/ZipCodeService", endpointInterface = "service.ZipCodeService")
public class ZipCodeServiceImpl implements ZipCodeService {

    private static final Map<Integer, State> states;

    static {
        states = new HashMap<>();
        states.put(84121, new State("Utah", "UT"));
        states.put(90210, new State("California", "CA"));
    }

    @Override
    public State getState(@WebParam(name = "zipCode", targetNamespace = "") Integer zipCode, @WebParam(name = "messages", targetNamespace = "") List<String> messages) {
        return null;
    }
}
