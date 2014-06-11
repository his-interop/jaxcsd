package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.msg.StartXmlElementFactory;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class ValueSetMarshaller extends Marshaller<ValueSet> {

    private static final ValueSetMarshaller INSTANCE = new ValueSetMarshaller();

    @Override
    public String marshal(ValueSet valueSet) {
        StringBuilder sb = new StringBuilder();
        sb.append(StartXmlElementFactory.getStartXmlElement("ValueSet", getAttributes(valueSet)));
        
        for(ConceptList conceptList:valueSet.getConceptLists()){
            sb.append(conceptList.marshal());
        }        
        
        sb.append("</ValueSet>");
        return sb.toString();
    }

    private Map<String, String> getAttributes(ValueSet valueSet) {
        Map<String, String> attributes = new LinkedHashMap<String, String>();
        attributes.put("xmlns", "urn:ihe:iti:svs:2008");
        attributes.put("xmlns:svs", "urn:ihe:iti:svs:2008");
        if (!JaxCsdUtil.isEmptyString(valueSet.getId())) {
            attributes.put("id", valueSet.getId());
        }
        if (!JaxCsdUtil.isEmptyString(valueSet.getVersion())) {
            attributes.put("version", valueSet.getVersion());
        }
        if (!JaxCsdUtil.isEmptyString(valueSet.getDisplayName())) {
            attributes.put("displayName", valueSet.getDisplayName());
        }
        return attributes;
    }

    public static ValueSetMarshaller get() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        ValueSet valueSet = new ValueSet();
        valueSet.setId("1.3.6.1.4.1.21367.200.101");
        valueSet.setVersion("20131201");
        valueSet.setDisplayName("CSD Organization Type Codes");
        ConceptList conceptList = new ConceptList();
        conceptList.setLang("en-US");
        conceptList.addConcept(new Concept("101-001", "Healthcare Information Exchange", "1.3.6.1.4.1.21367.100.1"));
        valueSet.addConceptList(conceptList);
        System.out.println(ValueSetMarshaller.get().marshal(valueSet));
    }
}
