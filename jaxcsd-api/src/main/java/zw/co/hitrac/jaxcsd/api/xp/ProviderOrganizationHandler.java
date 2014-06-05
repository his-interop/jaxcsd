package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganizations;

/**
 *
 * @author charles
 */
public class ProviderOrganizationHandler {
    
    public static void handle(ProviderOrganization providerOrganization, XMLStreamReader r) throws XMLStreamException {
         while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                //TODO: to add other handlers
            }else if (r.isEndElement()) {
                if ("organization".equals(r.getLocalName())) {
                    break;
                }
            }
         }

     }
    
}
