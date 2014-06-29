package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.msg.StartXmlElementFactory;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Daniel Nkhoma
 */
public class ConceptListMarshaler extends Marshaler<ConceptList> {

    private static final ConceptListMarshaler INSTANCE = new ConceptListMarshaler();

    @Override
    public String marshal(ConceptList conceptList, String elementName) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> attributes = new LinkedHashMap<String, String>();
        if (!JaxCsdUtil.isEmptyString(conceptList.getLang())) {
            attributes.put("xml:lang", conceptList.getLang());
        }
        sb.append(StartXmlElementFactory.getStartXmlElement(elementName, attributes));

        for (Concept concept : conceptList.getConcepts()) {
            sb.append(concept.marshal());
        }

        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(ConceptList conceptList) {
        return marshal(conceptList, CONCEPT_LIST);
    }

    private ConceptListMarshaler() {
    }

    public static ConceptListMarshaler get() {
        return INSTANCE;
    }
}
