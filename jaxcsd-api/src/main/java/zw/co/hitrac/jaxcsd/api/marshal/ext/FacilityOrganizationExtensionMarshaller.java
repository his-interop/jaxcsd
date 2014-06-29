package zw.co.hitrac.jaxcsd.api.marshal.ext;

import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.ext.FacilityOrganizationExtension;
import zw.co.hitrac.jaxcsd.api.marshal.ExtensionMarshaler;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationExtensionMarshaller extends ExtensionMarshaler<FacilityOrganizationExtension>{

    private static final FacilityOrganizationExtensionMarshaller INSTANCE=new FacilityOrganizationExtensionMarshaller();
    
    
    private FacilityOrganizationExtensionMarshaller() {
    }

    
    
    @Override
    protected Map<String, String> getAnyAttributes(FacilityOrganizationExtension extension) {
        return null;
    }

    @Override
    protected String getAnyXmlContent(FacilityOrganizationExtension extension) {
       StringBuilder sb=new StringBuilder();
       if(extension!=null && extension.getOrganizationName()!=null){
           sb.append("<facilityOrganizationExtension>");
           sb.append(getInlineXmlElement("organizationName", extension.getOrganizationName()));
           sb.append("</facilityOrganizationExtension>");
       }
       return sb.toString();
    }

    public static FacilityOrganizationExtensionMarshaller get() {
        return INSTANCE;
    }
}
