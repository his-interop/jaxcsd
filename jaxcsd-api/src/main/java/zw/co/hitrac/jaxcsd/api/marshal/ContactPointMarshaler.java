package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Arrays;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ContactPointMarshaler extends Marshaler<ContactPoint> {

    private static final ContactPointMarshaler INSTANCE = new ContactPointMarshaler();

    @Override
    public String marshal(ContactPoint contactPoint, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(">");
        sb.append(CodedTypeListMarshaler.get().marshal(Arrays.asList(contactPoint.getCodedType()), "codedType"));

        if (contactPoint.getEquipment() != null) {
            sb.append(getInlineXmlElement("equipment", contactPoint.getEquipment()));
        }

        if (contactPoint.getPurpose() != null) {
            sb.append(getInlineXmlElement("purpose", contactPoint.getPurpose()));
        }

        if (contactPoint.getCertificate() != null) {
            sb.append(getInlineXmlElement("certificate", contactPoint.getCertificate()));
        }

        sb.append("</").append(elementName).append(">");
        return sb.toString();

    }

    @Override
    public String marshal(ContactPoint contactPoint) {
        return marshal(contactPoint, CONTACT_POINT);
    }

    public static ContactPointMarshaler get() {
        return INSTANCE;
    }
}
