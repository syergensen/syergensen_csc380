package servlet;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import service.GreetingServiceImpl;
import service.ZipCodeServiceImpl;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

/**
 * User: Sean Yergensen
 */
public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/GreetingService", new GreetingServiceImpl());
        Endpoint.publish("/ZipCodeService", new ZipCodeServiceImpl());
    }
}
