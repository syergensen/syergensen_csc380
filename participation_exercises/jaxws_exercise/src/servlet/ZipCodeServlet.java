package servlet;

import generated.services.server.ZipCodeServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

/**
 * User: Sean Yergensen
 */
@WebServlet(urlPatterns = "/services/*")
public class ZipCodeServlet extends CXFNonSpringServlet {

    @Override
    protected void loadBus(ServletConfig sc) {
        super.loadBus(sc);

        // You could add the endpoint publish codes here
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/ZipCodeService", new ZipCodeServiceImpl());

        // You can als use the simple frontend API to do this
//        ServerFactoryBean factory = new ServerFactoryBean();
//        factory.setBus(bus);
//        factory.setServiceClass(ZipCodeService.class);
//        factory.setAddress("/ZipCodeService");
//        factory.create();
    }
}
