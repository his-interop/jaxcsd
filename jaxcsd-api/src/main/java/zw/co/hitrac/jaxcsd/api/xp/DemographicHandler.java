package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Person;

/**
 *
 * @author charles
 */
public class DemographicHandler {

    public static void handle(Person demographic, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if ("name".equals(r.getLocalName())) {
                    Name name = new Name();
                    demographic.getNames().add(name);
                    NameHandler.handle(name, r);
                } else if ("gender".equals(r.getLocalName())) {
                    demographic.setGender(HandlerUtils.getCharacters(r));
                } else if ("contactPoint".equals(r.getLocalName())) {
                    ContactPoint contactPoint = new ContactPoint();
                    demographic.getContactPoints().add(contactPoint);
                    ContactPointHandler.handle(contactPoint, r);
                } else if ("address".equals(r.getLocalName())) {
                    Address address = new Address();
                    address.setType(r.getAttributeValue("", "type"));
                    demographic.getAddresses().add(address);
                    AddressHandler.handle(address, r);
                }


            } else if (r.isEndElement()) {
                if ("demographic".equals(r.getLocalName())) {
                    break;
                }
            }
        }

    }
}
