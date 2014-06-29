package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ConceptMarshaler extends Marshaler<Concept> {

    private static final ConceptMarshaler INSTANCE = new ConceptMarshaler();

    public ConceptMarshaler() {
    }

    @Override
    public String marshal(Concept concept, String elementName) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> attributes = new LinkedHashMap<String, String>();
        attributes.put("code", concept.getCode());
        attributes.put("displayName", concept.getDisplayName());
        attributes.put("codeSystem", concept.getCodeSystem());
        sb.append(getInlineXmlElement(elementName, attributes));
        return sb.toString();
    }

    @Override
    public String marshal(Concept concept) {
        return marshal(concept, CONCEPT);
    }

    public static ConceptMarshaler get() {
        return INSTANCE;
    }
}
