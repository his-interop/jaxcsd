package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationDirectoryHandler {
    
    public static void handle(OrganizationDirectory organizationDirectory,XMLStreamReader r) throws XMLStreamException{
         while (r.hasNext()) {
                r.next();

                if (r.isStartElement()) {
                    if ("organization".equals(r.getLocalName())) {
                        Organization organization=new Organization();
                        organization.setOid(r.getAttributeValue("", "oid"));
                        organizationDirectory.getOrganizations().add(organization);
                        OrganizationHandler.handle(organization, r);                                
                    }


                } else if (r.isEndElement()) {
                    if ("organizationDirectory".equals(r.getLocalName())) {
                        break;
                    }
                }
            }
    }
}
