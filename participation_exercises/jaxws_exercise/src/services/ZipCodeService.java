package services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = ZipCodeService.TARGET_NAMESPACE, name = "ZipCodeService")
public interface ZipCodeService {

    public static final String TARGET_NAMESPACE = "http://localhost/ZipCodeService";

    @WebMethod
    public @WebResult State getState(@WebParam Integer zipCode, @WebParam List<String> messages);
}
