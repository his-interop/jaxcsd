package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.UniqueID;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class UniqueIDMarshaler extends Marshaler<UniqueID> {

    private static final UniqueIDMarshaler INSTANCE = new UniqueIDMarshaler();

    private UniqueIDMarshaler() {
    }

    @Override
    public String marshal(UniqueID uniqueId, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (uniqueId != null) {
            sb.append(getInlineXmlElement(elementName, new AttributesWrapper("entityID", uniqueId.getEntityID())));
        }
        return sb.toString();
    }

    @Override
    public String marshal(UniqueID parent) {
        return marshal(parent, "parent");
    }

    public static UniqueIDMarshaler get() {
        return INSTANCE;
    }
}
