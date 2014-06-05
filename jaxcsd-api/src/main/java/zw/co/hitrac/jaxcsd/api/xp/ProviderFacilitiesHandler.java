package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacilities;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacility;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilitiesHandler {
    
     public static void handle(ProviderFacilities providerFacilities, XMLStreamReader r) throws XMLStreamException {
         while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                if ("facility".equals(r.getLocalName())) {
                    ProviderFacility providerFacility=new ProviderFacility();
                    providerFacility.setOid(r.getAttributeValue("", "oid"));
                    providerFacilities.addProviderFacility(providerFacility);
                    ProviderFacilityHandler.handle(providerFacility, r);
                }
            }else if (r.isEndElement()) {
                if ("facilities".equals(r.getLocalName())) {
                    break;
                }
            }
         }

     }
}
