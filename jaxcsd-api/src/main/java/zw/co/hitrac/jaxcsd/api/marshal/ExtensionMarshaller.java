package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Extension;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class ExtensionMarshaller<T extends Extension> extends Marshaller<T> {


    @Override
    public final String marshal(T extension, String elementName) {
        StringBuilder sb = new StringBuilder();
        String anyXmlContent = getAnyXmlContent(extension);
        if (anyXmlContent != null && !anyXmlContent.trim().isEmpty()) {
            sb.append("<").append(elementName);
            sb.append(" type=\"").append(extension.getType()).append("\"");
            sb.append(" oid=\"").append(extension.getOid()).append("\"");
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
        return this.marshal(extension, "extension");
    }

    protected  abstract Map<String, String> getAnyAttributes(T extension);

    protected abstract String getAnyXmlContent(T extension);

    public static void main(String[] args) {
        ExtensionMarshaller extensionMarshaller = new ExtensionMarshaller() {
            @Override
            protected Map<String, String> getAnyAttributes(Extension extension) {
                Map<String, String> attributes = new LinkedHashMap<String, String>();
                attributes.put("key1", "value1");
                attributes.put("key2", "value2");
                return attributes;
            }

            @Override
            protected String getAnyXmlContent(Extension extension) {
                StringBuilder sb = new StringBuilder();
                sb.append("<providerExtension>");
                sb.append("</providerExtension>");
                return sb.toString();
            }
        };
        System.out.println(extensionMarshaller.marshal(new Extension("myType", "myOid"){}));
    }
}
