package generated.services.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-05T10:49:41.144-06:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://localhost/ZipCodeService", name = "ZipCodeService")
@XmlSeeAlso({ObjectFactory.class})
public interface ZipCodeService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getState", targetNamespace = "http://localhost/ZipCodeService", className = "generated.services.server.GetState")
    @WebMethod
    @ResponseWrapper(localName = "getStateResponse", targetNamespace = "http://localhost/ZipCodeService", className = "generated.services.server.GetStateResponse")
    public generated.services.server.State getState(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Integer arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1
    );
}