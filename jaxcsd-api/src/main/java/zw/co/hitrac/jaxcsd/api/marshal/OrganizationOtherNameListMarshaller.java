package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationOtherName;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationOtherNameListMarshaller extends Marshaller<List<OrganizationOtherName>> {

    private static final OrganizationOtherNameListMarshaller INSTANCE = new OrganizationOtherNameListMarshaller();

    private OrganizationOtherNameListMarshaller() {
    }

    @Override
    public String marshal(List<OrganizationOtherName> organizationOtherNames) {
        StringBuilder sb = new StringBuilder();
        if (organizationOtherNames != null && !organizationOtherNames.isEmpty()) {
            for (OrganizationOtherName organizationOtherName : organizationOtherNames) {
                Map<String, String> attributes = new LinkedHashMap<String, String>();
                if (organizationOtherName.getLang() != null) {
                    attributes.put("xml:lang", organizationOtherName.getLang());
                }
                sb.append(getInlineXmlElement("otherName", organizationOtherName.getValue(), attributes));
            }
        }
        return sb.toString();
    }

    public static OrganizationOtherNameListMarshaller get() {
        return INSTANCE;
    }
}
