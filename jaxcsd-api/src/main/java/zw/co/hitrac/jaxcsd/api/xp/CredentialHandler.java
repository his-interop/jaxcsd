package zw.co.hitrac.jaxcsd.api.xp;

import java.text.ParseException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class CredentialHandler {

    public static void handle(Credential credential, XMLStreamReader r) throws XMLStreamException, ParseException {
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
                    credential.setCodedType(codedType);
                }else if ("number".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        credential.setNumber(r.getText());
                    }
                }else if ("issuingAuthority".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        credential.setIssuingAuthority(r.getText());
                    }
                }else if ("credentialIssueDate".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        credential.setCredentialIssueDate(JaxCsdUtil.toDateFromIsoShortString(r.getText()));
                    }
                }else if ("credentialRenewalDate".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        credential.setCredentialRenewalDate(JaxCsdUtil.toDateFromIsoShortString(r.getText()));
                    }
                }
            } else if (r.isEndElement()) {
                if ("credential".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
