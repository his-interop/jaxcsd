package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Extension;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 * @param <T>
 */
public abstract class ExtensionMarshaler<T extends Extension> extends Marshaler<T> {

    @Override
    public final String marshal(T extension, String elementName) {
        StringBuilder sb = new StringBuilder();
        String anyXmlContent = getAnyXmlContent(extension);
        if (anyXmlContent != null && !anyXmlContent.trim().isEmpty()) {
            sb.append("<").append(elementName);
            sb.append(" type=\"").append(extension.getType()).append("\"");
            sb.append(" urn=\"").append(extension.getUrn()).append("\"");
            Map<String, String> attributes = getAnyAttributes(extension);
            if (attributes != null && !attributes.isEmpty()) {
                for (String attributeName : attributes.keySet()) {
                    sb.append(" ").append(attributeName).append("=\"");
                    sb.append(attributes.get(attributeName)).append("\"");
                }
            }
            sb.append(">");
            sb.append(anyXmlContent);
            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();
    }

    @Override
    public final String marshal(T extension) {
        return this.marshal(extension, EXTENSION);
    }

    protected abstract Map<String, String> getAnyAttributes(T extension);

    protected abstract String getAnyXmlContent(T extension);
}
