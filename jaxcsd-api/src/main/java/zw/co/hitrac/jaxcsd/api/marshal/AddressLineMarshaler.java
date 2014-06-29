package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Address.AddressLine;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class AddressLineMarshaler extends Marshaler<AddressLine> {

    private static final AddressLineMarshaler INSTANCE = new AddressLineMarshaler();

    public AddressLineMarshaler() {
    }

    @Override
    public String marshal(AddressLine addressLine, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append(getInlineXmlElement(elementName, addressLine.getLine(), new AttributesWrapper("component", addressLine.getComponent())));
        return sb.toString();
    }

    @Override
    public String marshal(AddressLine addressLine) {
        return this.marshal(addressLine, ADDRESS_LINE);
    }

    public static AddressLineMarshaler get() {
        return INSTANCE;
    }
}
