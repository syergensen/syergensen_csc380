package servlet;

import generated.services.server.ZipCodeService;
import generated.services.server.ZipCodeServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.namespace.QName;

/**
 * User: Sean Yergensen
 */
@WebServlet(urlPatterns = "/services/*")
public class ZipCodeServlet extends CXFNonSpringServlet {

    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig);

        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);

        createFactoryBean();
    }

    private void createFactoryBean() {
        JaxWsServerFactoryBean fb = new JaxWsServerFactoryBean();
        fb.setWsdlLocation("file:/C:/neumont/syergensen_csc380/participation_exercises/jaxws_exercise/src/generated/services/server/ZipCodeService.wsdl");
        fb.setAddress("/ZipCodeService");
        fb.setServiceBean(new ZipCodeServiceImpl());
        fb.setServiceClass(ZipCodeService.class);
        fb.setServiceName(new QName("http://localhost/ZipCodeService", "ZipCodeServicePort"));
        fb.create();
    }
}
