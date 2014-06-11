package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class ConceptMarshaller extends Marshaller<Concept>{
    
    private static final ConceptMarshaller INSTANCE=new ConceptMarshaller();

    private ConceptMarshaller() {
    }
    
    

    @Override
    public String marshal(Concept concept) {
      StringBuilder sb=new StringBuilder();
      Map<String,String> attributes=new LinkedHashMap<String, String>();
      attributes.put("code", concept.getCode());
      attributes.put("displayName", concept.getDisplayName());
      attributes.put("codeSystem", concept.getCodeSystem());
      sb.append(getInlineXmlElement("Concept", attributes));
      return sb.toString();
    }

    public static ConceptMarshaller get() {
        return INSTANCE;
    }
    
    
    
    public static void main(String[] args){
        Concept concept=new Concept("101-001","Healthcare Information Exchange", "1.3.6.1.4.1.21367.100.1");
        System.out.println(ConceptMarshaller.get().marshal(concept));
    }
    
}
