package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationOtherName;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationOtherNameListMarshaler extends Marshaler<List<OrganizationOtherName>> {

    private static final OrganizationOtherNameListMarshaler INSTANCE = new OrganizationOtherNameListMarshaler();

    private OrganizationOtherNameListMarshaler() {
    }
    
    @Override
    public String marshal(List<OrganizationOtherName> organizationOtherNames, String elementName) {
         StringBuilder sb = new StringBuilder();
        if (organizationOtherNames != null && !organizationOtherNames.isEmpty()) {
            for (OrganizationOtherName organizationOtherName : organizationOtherNames) {
               sb.append(organizationOtherName.marshal(elementName));
            }
        }
        return sb.toString();
    }

    @Override
    public String marshal(List<OrganizationOtherName> organizationOtherNames) {
       return marshal(organizationOtherNames, OTHER_NAME);
    }

    public static OrganizationOtherNameListMarshaler get() {
        return INSTANCE;
    }

    
}
