package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class AddressListMarshaler extends Marshaler<List<Address>> {

    private static final AddressListMarshaler INSTANCE = new AddressListMarshaler();

    private AddressListMarshaler() {
    }

    @Override
    public String marshal(List<Address> addresses, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                sb.append(address.marshal(elementName));
            }
        }
        return sb.toString();

    }

    @Override
    public String marshal(List<Address> addresses) {
        return marshal(addresses, ADDRESS);
    }

    public static AddressListMarshaler get() {
        return INSTANCE;
    }
}
