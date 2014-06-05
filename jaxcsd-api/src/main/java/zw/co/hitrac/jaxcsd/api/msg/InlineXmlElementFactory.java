package zw.co.hitrac.jaxcsd.api.msg;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Charles Chigoriwa
 */
public class InlineXmlElementFactory {
    
    public static final String EMPTY_VALUE="";

    private InlineXmlElementFactory( ) {
    }
    
    public static String getInlineXmlElement(String elementName){
        return getInlineXmlElement(elementName, EMPTY_VALUE,(Map<String, String>)null);
    }
    
    public static String getInlineXmlElement(String elementName, String elementValue){
        return getInlineXmlElement(elementName, elementValue,(Map<String, String>)null);
    }
    
    public static String getInlineXmlElement(String elementName,  AttributesWrapper attributesWrapper){
       return getInlineXmlElement(elementName, EMPTY_VALUE, attributesWrapper);
    }
    
    public static String getInlineXmlElement(String elementName, String elementValue, AttributesWrapper attributesWrapper){
        if(attributesWrapper==null || attributesWrapper.getAttributes()==null || attributesWrapper.getAttributes().isEmpty()){
            return getInlineXmlElement(elementName, elementValue);
        }else{
            return getInlineXmlElement(elementName, elementValue, attributesWrapper.getAttributes());
        }
    }
    
    public static String getInlineXmlElement(String elementName,Map<String, String> attributes){
        return getInlineXmlElement(elementName,EMPTY_VALUE, attributes);
    }

    public static String getInlineXmlElement(String elementName, String elementValue, Map<String, String> attributes) {
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
        sb.append(elementValue);
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    public static void main(String[] args) {
        String elementName = "codedType";
        String elementValue = "Physician/Medical Oncology";
        Map<String, String> attributes = new LinkedHashMap<String, String>();
        attributes.put("code", "105-007");
        attributes.put("codingSchema", "1.3.6.1.4.1.21367.100.1");
        System.out.println(getInlineXmlElement(elementName, attributes));
    }
}
