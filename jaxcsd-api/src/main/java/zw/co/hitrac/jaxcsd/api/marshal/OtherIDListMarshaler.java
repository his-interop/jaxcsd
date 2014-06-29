package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OtherIDListMarshaler extends Marshaler<List<OtherID>> {
    
    private static final OtherIDListMarshaler INSTANCE=new OtherIDListMarshaler();

    private OtherIDListMarshaler() {
    }

    @Override
    public String marshal(List<OtherID> otherIDs) {
       return marshal(otherIDs, OTHER_ID);
    }

    public static OtherIDListMarshaler get() {
        return INSTANCE;
    }

    @Override
    public String marshal(List<OtherID> otherIDs, String elementName) {
       StringBuilder sb = new StringBuilder();
        if (otherIDs != null && !otherIDs.isEmpty()) {
            for (OtherID otherID : otherIDs) {
               sb.append(otherID.marshal(elementName));
            }
        }
        return sb.toString();
    }
    
    
}
