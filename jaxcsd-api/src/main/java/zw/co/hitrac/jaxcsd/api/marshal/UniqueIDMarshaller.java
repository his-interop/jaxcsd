package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.UniqueID;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class UniqueIDMarshaller extends Marshaller<UniqueID> {

    private static final UniqueIDMarshaller INSTANCE = new UniqueIDMarshaller();

    private UniqueIDMarshaller() {
    }

    @Override
    public String marshal(UniqueID uniqueId, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (uniqueId != null) {
            sb.append(getInlineXmlElement(elementName, new AttributesWrapper("oid", uniqueId.getOid())));
        }
        return sb.toString();
    }

    @Override
    public String marshal(UniqueID parent) {
        return marshal(parent, "parent");
    }

    public static UniqueIDMarshaller get() {
        return INSTANCE;
    }
}
