package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class AddressMarshaller extends Marshaller<Address> {

    private static final AddressMarshaller INSTANCE = new AddressMarshaller();

    public AddressMarshaller() {
    }

    @Override
    public String marshal(Address address, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (address.getAddressLines() != null && !address.getAddressLines().isEmpty()) {
            sb.append("<").append(elementName).append(" type=\"").append(address.getType()).append("\">");
            for (Address.AddressLine addressLine : address.getAddressLines()) {
                sb.append(getInlineXmlElement("addressLine", addressLine.getLine(), new AttributesWrapper("component", addressLine.getComponent())));
            }
            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();

    }

    @Override
    public String marshal(Address address) {
        return marshal(address, "address");
    }
}
