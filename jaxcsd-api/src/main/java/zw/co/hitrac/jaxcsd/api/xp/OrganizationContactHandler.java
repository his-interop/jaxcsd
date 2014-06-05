package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationContact;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationContactHandler {
    
     public static void handle(OrganizationContact contact, XMLStreamReader r) throws XMLStreamException{
         while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                //TODO: to deal with inner handlers later!
            }else if (r.isEndElement()) {
                if ("contact".equals(r.getLocalName())) {
                    break;
                }
            }
         }
     }
}
