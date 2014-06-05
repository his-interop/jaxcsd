package zw.co.hitrac.jaxcsd.api.msg;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author 
 */
public class AttributesWrapper implements Serializable{
    
    private final Map<String,String> attributes=new LinkedHashMap<String, String>();

    public AttributesWrapper() {
    }

    public AttributesWrapper(String attributeName,String attributeValue) {
        attributes.put(attributeName, attributeValue);
    }
    
    
    
    public AttributesWrapper add(String attributeName,String attributeValue){
        attributes.put(attributeName, attributeValue);
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
    
}
