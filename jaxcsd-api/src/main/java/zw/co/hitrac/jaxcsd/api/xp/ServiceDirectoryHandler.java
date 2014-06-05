package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceDirectoryHandler {
    
     public static void handle(ServiceDirectory serviceDirectory, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("service".equals(r.getLocalName())) {
                    Service service=new Service();
                    service.setOid(r.getAttributeValue("", "oid"));
                    serviceDirectory.getServices().add(service);
                    ServiceHandler.handle(service,r);
                }

            } else if (r.isEndElement()) {
                if ("serviceDirectory".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
    
}
