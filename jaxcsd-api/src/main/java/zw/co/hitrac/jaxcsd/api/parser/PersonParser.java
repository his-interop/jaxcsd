package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.parser.util.HandlerUtils;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Person;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class PersonParser extends AbstractCsdParser<Person> {
    
    private AddressParser addressParser=new AddressParser();
    private NameParser nameParser=new NameParser();
    private ContactPointParser contactPointParser=new ContactPointParser();

    @Override
    public void parse(Person person, CsdElement personElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
         while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (NAME_ELEMENT.elementEquals(r)) {
                    Name name = new Name();
                    person.getNames().add(name);
                    nameParser.parse(name, NAME_ELEMENT, r, csdParserExtensions);
                } else if (GENDER_ELEMENT.elementEquals(r)) {
                    person.setGender(HandlerUtils.getCharacters(r));
                } else if (CONTACT_POINT_ELEMENT.elementEquals(r)) {
                    ContactPoint contactPoint = new ContactPoint();
                    person.getContactPoints().add(contactPoint);
                    contactPointParser.parse(contactPoint,CONTACT_POINT_ELEMENT, r, csdParserExtensions);
                } else if (ADDRESS_ELEMENT.elementEquals(r)) {
                    Address address = new Address();
                    address.setType(r.getAttributeValue("", "type"));
                    person.getAddresses().add(address);
                    addressParser.parse(address, ADDRESS_ELEMENT, r, csdParserExtensions);
                }

            } else if (r.isEndElement()) {
                if (personElement.elementEquals(r)) {
                    break;
                }
            }
        }

    }

    public void setAddressParser(AddressParser addressParser) {
        this.addressParser = addressParser;
    }

    public void setNameParser(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    public void setContactPointParser(ContactPointParser contactPointParser) {
        this.contactPointParser = contactPointParser;
    }
       
    
    
    public static final CsdElement NAME_ELEMENT=new CsdElement(NAME);
    public static final CsdElement GENDER_ELEMENT=new CsdElement(GENDER);
    public static final CsdElement CONTACT_POINT_ELEMENT=new CsdElement(CONTACT_POINT);
    public static final CsdElement ADDRESS_ELEMENT=new CsdElement(ADDRESS);
    
    

   
}
