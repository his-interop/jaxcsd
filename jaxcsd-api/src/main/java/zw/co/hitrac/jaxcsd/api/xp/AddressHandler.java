package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.Address.AddressLine;

/**
 *
 * @author Charles Chigoriwa
 */
public class AddressHandler {
    
    public static void handle(Address address, XMLStreamReader r) throws XMLStreamException {
        
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if ("addressLine".equals(r.getLocalName())) {                    
                    AddressLine addressLine = new AddressLine();
                    addressLine.setComponent(r.getAttributeValue("", "component"));
                    r.next();
                    if (r.isCharacters()) {
                        addressLine.setLine(r.getText());
                        address.getAddressLines().add(addressLine);
                    }
                }
            } else if (r.isEndElement()) {
                if ("address".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
