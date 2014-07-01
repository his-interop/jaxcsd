package zw.co.hitrac.jaxcsd.api.parser.util;

import java.math.BigDecimal;
import java.text.ParseException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationOtherName;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.parser.CredentialParser;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class HandlerUtils {

    public static OtherID getOtherID(XMLStreamReader r) {
        OtherID otherID = new OtherID();
        otherID.setCode(r.getAttributeValue("", "code"));
        otherID.setAssigningAuthorityName(r.getAttributeValue("", "assigningAuthorityName"));
        return otherID;
    }

    public static CodedType getCodedType(XMLStreamReader r) throws XMLStreamException {
        CodedType codedType = new CodedType();
        codedType.setCode(r.getAttributeValue("", "code"));
        codedType.setCodingSchema(r.getAttributeValue("", "codingSchema"));
        codedType.setValue(getCharacters(r));
        return codedType;
    }

    public static AbstractOrganization.OrganizationOtherName getOtherName(XMLStreamReader r) throws XMLStreamException {
        OrganizationOtherName otherName = new AbstractOrganization.OrganizationOtherName();
        otherName.setLang(r.getAttributeValue("", "xml:lang"));
        otherName.setValue(getCharacters(r));
        return otherName;
    }

    public static Credential getCredential(XMLStreamReader r) throws XMLStreamException {
        Credential credential = new Credential();
        //TODO: to assemble this parser in a container/factory
        CredentialParser credentialParser = new CredentialParser();
        //TODO: to parameterize
        credentialParser.parse(credential, new CsdElement(CsdElementConstants.CREDENTIAL), r, null);
        return credential;
    }

    public static Record getRecord(XMLStreamReader r) {
        Record record = new Record();
        record.setStatus(r.getAttributeValue("", "status"));
        return record;
    }

    public static String getCharacters(XMLStreamReader r) throws XMLStreamException {
        r.next();
        if (r.isCharacters()) {
            return r.getText();
        } else {
            return null;
        }
    }

    public static BigDecimal getBigDecimal(XMLStreamReader r) throws XMLStreamException {
        r.next();
        if (r.isCharacters()) {
            return new BigDecimal(r.getText());
        } else {
            return null;
        }
    }
}
