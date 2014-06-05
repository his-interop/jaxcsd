package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class OtherIDListMarshaller extends Marshaller<List<OtherID>> {
    
    private static final OtherIDListMarshaller INSTANCE=new OtherIDListMarshaller();

    private OtherIDListMarshaller() {
    }
    
    

    @Override
    public String marshal(List<OtherID> otherIDs) {
        StringBuilder sb = new StringBuilder();
        if (otherIDs != null && !otherIDs.isEmpty()) {
            for (OtherID otherID : otherIDs) {
                Map<String, String> attributes = new LinkedHashMap<String, String>();
                attributes.put("code", otherID.getCode());
                attributes.put("assigningAuthorityName", otherID.getAssigningAuthorityName());
                sb.append(getInlineXmlElement("otherID", attributes));
            }
        }
        return sb.toString();
    }

    public static OtherIDListMarshaller get() {
        return INSTANCE;
    }
    
    
}
