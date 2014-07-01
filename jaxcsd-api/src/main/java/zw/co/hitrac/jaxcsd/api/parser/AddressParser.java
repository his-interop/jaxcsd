package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.Address.AddressLine;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class AddressParser extends AbstractCsdParser<Address> {
    
    public static final CsdElement addressLineElement=new CsdElement(CsdElementConstants.ADDRESS_LINE);
    
    @Override
    public void parse(Address address, CsdElement addressElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (addressLineElement.elementEquals(r)) {                    
                    AddressLine addressLine = new AddressLine();
                    addressLine.setComponent(r.getAttributeValue("", "component"));
                    r.next();
                    if (r.isCharacters()) {
                        addressLine.setLine(r.getText());
                        address.getAddressLines().add(addressLine);
                    }
                }
            } else if (r.isEndElement()) {
                if (addressElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }
}
