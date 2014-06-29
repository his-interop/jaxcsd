package zw.co.hitrac.jaxcsd.api.marshal.ext;

import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.ext.ProviderOrganizationExtension;
import zw.co.hitrac.jaxcsd.api.marshal.ExtensionMarshaler;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Daniel Nkhoma
 */
public class ProviderOrganizationExtensionMarshaller extends ExtensionMarshaler<ProviderOrganizationExtension> {

    private static final ProviderOrganizationExtensionMarshaller INSTANCE = new ProviderOrganizationExtensionMarshaller();

    public ProviderOrganizationExtensionMarshaller() {
    }

    @Override
    protected Map<String, String> getAnyAttributes(ProviderOrganizationExtension extension) {
        return null;
    }

    @Override
    protected String getAnyXmlContent(ProviderOrganizationExtension extension) {
        StringBuilder sb = new StringBuilder();
        if (extension != null && extension.getProviderName() != null) {
            sb.append("<providerOrganizationExtension>");
            sb.append(getInlineXmlElement("organizationName", extension.getProviderName()));
            sb.append("</providerOrganizationExtension>");
        }
        return sb.toString();
    }

    public static ProviderOrganizationExtensionMarshaller get() {
        return INSTANCE;
    }
}
