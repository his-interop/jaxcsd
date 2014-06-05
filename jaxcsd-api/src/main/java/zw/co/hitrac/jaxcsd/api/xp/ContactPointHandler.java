package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;

/**
 *
 * @author Charles Chigoriwa
 */
public class ContactPointHandler {

    public static void handle(ContactPoint contactPoint, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if ("codedType".equals(r.getLocalName())) {
                    CodedType codedType = new CodedType();
                    codedType.setCode(r.getAttributeValue("", "code"));
                    codedType.setCodingSchema(r.getAttributeValue("", "codingSchema"));
                    r.next();
                    if (r.isCharacters()) {
                        codedType.setValue(r.getText());
                    }                    
                    contactPoint.setCodedType(codedType);
                }else if ("equipment".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        contactPoint.setEquipment(r.getText());
                    }
                }else if ("purpose".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        contactPoint.setPurpose(r.getText());
                    }
                }else if ("certificate".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        contactPoint.setCertificate(r.getText());
                    }
                }
            } else if (r.isEndElement()) {
                if ("contactPoint".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
