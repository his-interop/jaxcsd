package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacility;

/**
 *
 * @author charles
 */
public class ProviderFacilityHandler {
    
    public static void handle(ProviderFacility providerFacility, XMLStreamReader r) throws XMLStreamException {
         while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                //TODO: to add other handlers
            }else if (r.isEndElement()) {
                if ("facility".equals(r.getLocalName())) {
                    break;
                }
            }
         }

     }
    
}
