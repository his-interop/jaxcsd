package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Arrays;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class ContactPointListMarshaller extends Marshaller<List<ContactPoint>> {

    private final static ContactPointListMarshaller INSTANCE = new ContactPointListMarshaller();

    private ContactPointListMarshaller() {
    }

    @Override
    public String marshal(List<ContactPoint> contactPoints) {
        StringBuilder sb = new StringBuilder();
        if (contactPoints != null && !contactPoints.isEmpty()) {
            for (ContactPoint contactPoint : contactPoints) {                
                sb.append("<contactPoint>");
                sb.append(CodedTypeListMarshaller.get().marshal(Arrays.asList(contactPoint.getCodedType()),"codedType"));
                
                if (contactPoint.getEquipment() != null) {
                    sb.append(getInlineXmlElement("equipment", contactPoint.getEquipment()));
                }
                
                if(contactPoint.getPurpose()!=null){
                    sb.append(getInlineXmlElement("purpose", contactPoint.getPurpose()));
                }
                
                if(contactPoint.getCertificate()!=null){
                    sb.append(getInlineXmlElement("certificate", contactPoint.getCertificate()));
                }
                
                sb.append("</contactPoint>");
                
                
            }
        }
        return sb.toString();
    }

    public static ContactPointListMarshaller get() {
        return INSTANCE;
    }
}
