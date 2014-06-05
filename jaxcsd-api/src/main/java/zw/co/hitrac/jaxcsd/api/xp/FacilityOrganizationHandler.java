package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import zw.co.hitrac.jaxcsd.api.domain.ext.FacilityOrganizationExtension;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationHandler {

    public static void handle(FacilityOrganization organization, XMLStreamReader r) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                //TODO: Add a Facility service handler
                
                if("extension".equals(r.getLocalName())){
                    FacilityOrganizationExtension extension=new FacilityOrganizationExtension();
                    organization.getExtensions().add(extension);
                    ExtensionHandler.handle(extension, r);
                }
                
            } else if (r.isEndElement()) {
                if ("organization".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
