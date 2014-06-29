package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Arrays;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class CredentialMarshaler extends Marshaler<Credential> {

    private static final CredentialMarshaler INSTANCE = new CredentialMarshaler();

    @Override
    public String marshal(Credential credential, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(">");
        sb.append(CodedTypeListMarshaler.get().marshal(Arrays.asList(credential.getCodedType())));
        sb.append(getInlineXmlElement("number", credential.getNumber()));
        if (credential.getIssuingAuthority() != null) {
            sb.append(getInlineXmlElement("issuingAuthority", credential.getIssuingAuthority()));
        }

        if (credential.getCredentialIssueDate() != null) {
            sb.append(getInlineXmlElement("credentialIssueDate", JaxCsdUtil.toIsoShortDateFormatString(credential.getCredentialIssueDate())));
        }

        if (credential.getCredentialRenewalDate() != null) {
            sb.append(getInlineXmlElement("credentialRenewalDate", JaxCsdUtil.toIsoShortDateFormatString(credential.getCredentialRenewalDate())));
        }

        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(Credential credential) {
        return marshal(credential, CREDENTIAL);
    }

    public static CredentialMarshaler get() {
        return INSTANCE;
    }
}
