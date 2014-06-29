package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OtherIDMarshaler extends Marshaler<OtherID> {
    
    private static final OtherIDMarshaler INSTANCE=new OtherIDMarshaler();

    @Override
    public String marshal(OtherID otherID) {
       return marshal(otherID, OTHER_ID);
    }

    @Override
    public String marshal(OtherID otherID, String elementName) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> attributes = new LinkedHashMap<String, String>();
        attributes.put("code", otherID.getCode());
        attributes.put("assigningAuthorityName", otherID.getAssigningAuthorityName());
        sb.append(getInlineXmlElement(elementName, attributes));
        return sb.toString();
    }

    public static OtherIDMarshaler get() {
        return INSTANCE;
    }
    
    
}
