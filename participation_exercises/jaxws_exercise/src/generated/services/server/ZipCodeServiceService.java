package generated.services.server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-05T11:03:52.992-06:00
 * Generated source version: 2.7.6
 * 
 */
@WebServiceClient(name = "ZipCodeServiceService", 
                  wsdlLocation = "file:/C:/neumont/syergensen_csc380/participation_exercises/jaxws_exercise/src/generated/services/server/ZipCodeService.wsdl",
                  targetNamespace = "http://localhost/ZipCodeService") 
public class ZipCodeServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://localhost/ZipCodeService", "ZipCodeServiceService");
    public final static QName ZipCodeServicePort = new QName("http://localhost/ZipCodeService", "ZipCodeServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/neumont/syergensen_csc380/participation_exercises/jaxws_exercise/src/generated/services/server/ZipCodeService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ZipCodeServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/neumont/syergensen_csc380/participation_exercises/jaxws_exercise/src/generated/services/server/ZipCodeService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ZipCodeServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ZipCodeServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ZipCodeServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ZipCodeServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ZipCodeServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ZipCodeServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ZipCodeService
     */
    @WebEndpoint(name = "ZipCodeServicePort")
    public ZipCodeService getZipCodeServicePort() {
        return super.getPort(ZipCodeServicePort, ZipCodeService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ZipCodeService
     */
    @WebEndpoint(name = "ZipCodeServicePort")
    public ZipCodeService getZipCodeServicePort(WebServiceFeature... features) {
        return super.getPort(ZipCodeServicePort, ZipCodeService.class, features);
    }

}
