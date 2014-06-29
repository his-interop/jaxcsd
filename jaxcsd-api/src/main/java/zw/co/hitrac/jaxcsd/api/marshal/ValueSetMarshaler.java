package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.msg.StartXmlElementFactory;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ValueSetMarshaler extends Marshaler<ValueSet> {

    private static final ValueSetMarshaler INSTANCE = new ValueSetMarshaler();

    @Override
    public String marshal(ValueSet valueSet, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append(StartXmlElementFactory.getStartXmlElement(elementName, getAttributes(valueSet)));

        for (ConceptList conceptList : valueSet.getConceptLists()) {
            sb.append(conceptList.marshal());
        }

        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(ValueSet valueSet) {
        return marshal(valueSet, VALUE_SET);
        
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

    public static ValueSetMarshaler get() {
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
        System.out.println(ValueSetMarshaler.get().marshal(valueSet));
    }
}
