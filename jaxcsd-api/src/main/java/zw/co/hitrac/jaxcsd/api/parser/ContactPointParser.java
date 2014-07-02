package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class ContactPointParser extends AbstractCsdParser<ContactPoint> {
    
    @Override
    public void parse(ContactPoint contactPoint, CsdElement contactPointElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if ("codedType".equals(r.getLocalName())) {
                    CodedType codedType = new CodedType();
                    codedType.setCode(r.getAttributeValue("", "code"));
                    codedType.setCodingScheme(r.getAttributeValue("", "codingScheme"));
                    r.next();
                    if (r.isCharacters()) {
                        codedType.setValue(r.getText());
                    }
                    contactPoint.setCodedType(codedType);
                } else if ("equipment".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        contactPoint.setEquipment(r.getText());
                    }
                } else if ("purpose".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        contactPoint.setPurpose(r.getText());
                    }
                } else if ("certificate".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        contactPoint.setCertificate(r.getText());
                    }
                }
            } else if (r.isEndElement()) {
                if (contactPointElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }
}
