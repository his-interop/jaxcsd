package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganizations;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizationsHandler {
    
     public static void handle(ProviderOrganizations providerOrganizations, XMLStreamReader r) throws XMLStreamException {
         while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                if ("organization".equals(r.getLocalName())) {
                    ProviderOrganization providerOrganization=new ProviderOrganization();
                    providerOrganization.setOid(r.getAttributeValue("", "oid"));
                    providerOrganizations.addProviderOrganization(providerOrganization);
                    ProviderOrganizationHandler.handle(providerOrganization, r);
                }
            }else if (r.isEndElement()) {
                if ("organizations".equals(r.getLocalName())) {
                    break;
                }
            }
         }

     }
}
