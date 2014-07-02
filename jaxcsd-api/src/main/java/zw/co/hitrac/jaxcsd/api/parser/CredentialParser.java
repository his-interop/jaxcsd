package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class CredentialParser extends AbstractCsdParser<Credential>{
    
    @Override
    public void parse(final Credential credential, CsdElement credentialElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
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
                if (credentialElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

   

    
}
