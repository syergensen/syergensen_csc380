
package generated.services.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.services.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetState_QNAME = new QName("http://localhost/ZipCodeService", "getState");
    private final static QName _GetStateResponse_QNAME = new QName("http://localhost/ZipCodeService", "getStateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.services.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetState }
     * 
     */
    public GetState createGetState() {
        return new GetState();
    }

    /**
     * Create an instance of {@link GetStateResponse }
     * 
     */
    public GetStateResponse createGetStateResponse() {
        return new GetStateResponse();
    }

    /**
     * Create an instance of {@link State }
     * 
     */
    public State createState() {
        return new State();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/ZipCodeService", name = "getState")
    public JAXBElement<GetState> createGetState(GetState value) {
        return new JAXBElement<GetState>(_GetState_QNAME, GetState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/ZipCodeService", name = "getStateResponse")
    public JAXBElement<GetStateResponse> createGetStateResponse(GetStateResponse value) {
        return new JAXBElement<GetStateResponse>(_GetStateResponse_QNAME, GetStateResponse.class, null, value);
    }

}
