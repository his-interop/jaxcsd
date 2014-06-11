package zw.co.hitrac.jaxcsd.api.msg;

import java.util.Map;

/**
 *
 * @author Charles Chigoriwa
 */
public class StartXmlElementFactory {
    
    public static String getStartXmlElement(String elementName, Map<String, String> attributes) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName);
        if (attributes != null && !attributes.isEmpty()) {
            for (String attributeName : attributes.keySet()) {
                sb.append(" ");
                sb.append(attributeName).append("=");
                sb.append("\"").append(attributes.get(attributeName)).append("\"");
            }
        }
        sb.append(">");
        return sb.toString();
    }
    
}
