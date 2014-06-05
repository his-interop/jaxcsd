package zw.co.hitrac.jaxcsd.api.marshal.ext;

import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.ext.ProviderFacilityExtension;
import zw.co.hitrac.jaxcsd.api.marshal.ExtensionMarshaller;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Daniel Nkhoma
 */
public class ProviderFacilityExtensionMarshaller extends ExtensionMarshaller<ProviderFacilityExtension> {

    private static final ProviderFacilityExtensionMarshaller INSTANCE = new ProviderFacilityExtensionMarshaller();

    @Override
    protected Map<String, String> getAnyAttributes(ProviderFacilityExtension extension) {
        return null;
    }

    @Override
    protected String getAnyXmlContent(ProviderFacilityExtension extension) {
        StringBuilder sb = new StringBuilder();
        if (extension != null && extension.getFacilityName() != null) {
            sb.append("<providerFacilityExtension>");
            sb.append(getInlineXmlElement("facilityName", extension.getFacilityName()));
            sb.append("</providerFacilityExtension>");
        }

        return sb.toString();
    }

    public static ProviderFacilityExtensionMarshaller get() {
        return INSTANCE;
    }
}
