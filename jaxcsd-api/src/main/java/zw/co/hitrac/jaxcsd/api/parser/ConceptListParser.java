package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ConceptListParser extends AbstractCsdParser<ConceptList> {

    @Override
    public void parse(ConceptList conceptList, CsdElement conceptListElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (CONCEPT_ELEMENT.elementEquals(r)) {
                    Concept concept = new Concept();
                    concept.setCode(r.getAttributeValue("", "code"));
                    concept.setDisplayName(r.getAttributeValue("", "displayName"));
                    concept.setCodeSystem(r.getAttributeValue("", "codeSystem"));
                    conceptList.addConcept(concept);
                }
            } else if (r.isEndElement()) {
                if (conceptListElement.elementEquals(r)) {
                    break;
                }
            }
        }

    }
    
    public static final CsdElement CONCEPT_ELEMENT=new CsdElement(CONCEPT);
}
