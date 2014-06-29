package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationOtherNameMarshaler extends Marshaler<AbstractOrganization.OrganizationOtherName> {

   private static final OrganizationOtherNameMarshaler INSTANCE=new OrganizationOtherNameMarshaler();
    
    @Override
    public String marshal(AbstractOrganization.OrganizationOtherName organizationOtherName) {
        return marshal(organizationOtherName, OTHER_NAME);
    }

    @Override
    public String marshal(AbstractOrganization.OrganizationOtherName organizationOtherName, String elementName) {
        StringBuilder sb=new StringBuilder();
        Map<String, String> attributes = new LinkedHashMap<String, String>();
        if (organizationOtherName.getLang() != null) {
            attributes.put("xml:lang", organizationOtherName.getLang());
        }
        sb.append(getInlineXmlElement(elementName, organizationOtherName.getValue(), attributes));
        return sb.toString();
    }

    public static OrganizationOtherNameMarshaler get() {
        return INSTANCE;
    }
    
    
}
