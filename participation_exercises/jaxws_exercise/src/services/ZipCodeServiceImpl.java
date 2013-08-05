package services;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * User: Sean Yergensen
 */
@WebService(serviceName = "ZipCodeService", targetNamespace = "http://localhost/ZipCodeService",
        portName = "ZipCodeServicePort", endpointInterface = "generated.services.server.ZipCodeService")
public class ZipCodeServiceImpl implements ZipCodeService {
    @Override
    public State getState(@WebParam(name = "zipCode", targetNamespace = "") Integer zipCode, @WebParam(name = "messages", targetNamespace = "") List<String> messages) {
        return null;
    }
}
