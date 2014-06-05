package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.Address.AddressLine;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class AddressListMarshaller extends Marshaller<List<Address>> {

    private static final AddressListMarshaller INSTANCE = new AddressListMarshaller();

    private AddressListMarshaller() {
    }

    @Override
    public String marshal(List<Address> addresses) {
        StringBuilder sb = new StringBuilder();
        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                if (address.getAddressLines() != null && !address.getAddressLines().isEmpty()) {
                    if (address.getType() != null) {
                        sb.append("<address type=\"").append(address.getType()).append("\">");
                    } else {
                        sb.append("<address>");
                    }
                    for (AddressLine addressLine : address.getAddressLines()) {
                        sb.append(getInlineXmlElement("addressLine", addressLine.getLine(), new AttributesWrapper("component", addressLine.getComponent())));
                    }
                    sb.append("</address>");
                }
            }
        }
        return sb.toString();

    }

    public static AddressListMarshaller get() {
        return INSTANCE;
    }
}
