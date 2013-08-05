package services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://localhost/ZipCodeService", name = "ZipCodeService")
public interface ZipCodeService {

    @WebMethod
    public @WebResult State getState(@WebParam(name = "zipCode") Integer zipCode, @WebParam List<String> messages);
}
