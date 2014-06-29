package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Address;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class AddressMarshaler extends Marshaler<Address> {

    private static final AddressMarshaler INSTANCE = new AddressMarshaler();

    public AddressMarshaler() {
    }

    @Override
    public String marshal(Address address, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (address.getAddressLines() != null && !address.getAddressLines().isEmpty()) {
            if (address.getType() != null) {
                sb.append("<").append(elementName).append(" type=\"").append(address.getType()).append("\">");
            } else {
                sb.append("<").append(elementName).append("\">");
            }
            for (Address.AddressLine addressLine : address.getAddressLines()) {
                addressLine.marshal();
            }
            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();

    }

    @Override
    public String marshal(Address address) {
        return marshal(address, ADDRESS);
    }

    public static AddressMarshaler get() {
        return INSTANCE;
    }
}
