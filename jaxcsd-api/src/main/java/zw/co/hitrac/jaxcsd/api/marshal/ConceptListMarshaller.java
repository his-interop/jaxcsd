package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.msg.StartXmlElementFactory;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Daniel Nkhoma
 */
public class ConceptListMarshaller extends Marshaller<ConceptList> {
    
    private static final ConceptListMarshaller INSTANCE=new ConceptListMarshaller();

    private ConceptListMarshaller() {
    }
    
    

    @Override
    public String marshal(ConceptList conceptList) {
        StringBuilder sb = new StringBuilder();        
        Map<String,String> attributes=new LinkedHashMap<String, String>();        
        if(!JaxCsdUtil.isEmptyString(conceptList.getLang())) {            
            attributes.put("xml:lang",conceptList.getLang());
        }          
        sb.append(StartXmlElementFactory.getStartXmlElement("ConceptList", attributes));
        
        for(Concept concept:conceptList.getConcepts()){
            sb.append(concept.marshal());
        }        
        
        sb.append("</ConceptList>");
        return sb.toString();
    }

    public static ConceptListMarshaller get() {
        return INSTANCE;
    }
    
    public static void main(String[] args){
        ConceptList conceptList=new ConceptList();
        conceptList.setLang("en-US");
        conceptList.addConcept(new Concept("101-001","Healthcare Information Exchange", "1.3.6.1.4.1.21367.100.1"));
        System.out.println(ConceptListMarshaller.get().marshal(conceptList));
    }
    
    
    
    
}
