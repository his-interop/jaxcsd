package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Arrays;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class CredentialListMarshaller extends Marshaller<List<Credential>> {
    
    private static final CredentialListMarshaller INSTANCE=new CredentialListMarshaller();

    private CredentialListMarshaller() {
    }
    
    

    @Override
    public String marshal(List<Credential> credentials) {
        StringBuilder sb = new StringBuilder();
        for (Credential credential : credentials) {
            sb.append("<credential>");
            sb.append(CodedTypeListMarshaller.get().marshal(Arrays.asList(credential.getCodedType())));
            sb.append(getInlineXmlElement("number", credential.getNumber()));
            if (credential.getIssuingAuthority() != null) {
                sb.append(getInlineXmlElement("issuingAuthority", credential.getIssuingAuthority()));
            }
            
            if(credential.getCredentialIssueDate()!=null){
                sb.append(getInlineXmlElement("credentialIssueDate", JaxCsdUtil.toIsoShortDateFormatString(credential.getCredentialIssueDate())));
            }
            
            if(credential.getCredentialRenewalDate()!=null){
                sb.append(getInlineXmlElement("credentialRenewalDate", JaxCsdUtil.toIsoShortDateFormatString(credential.getCredentialRenewalDate())));
            }
            
            

            sb.append("</credential>");
        }
        return sb.toString();
    }

    public static CredentialListMarshaller get() {
        return INSTANCE;
    }
    
    
}
