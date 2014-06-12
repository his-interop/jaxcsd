package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;

/**
 *
 * @author Charles Chigoriwa
 */
public class ConceptListHandler {

    public static void handle(ConceptList conceptList, XMLStreamReader r) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                String localName = r.getLocalName();
                if ("Concept".equals(localName)) {
                   Concept concept=new Concept();
                   concept.setCode(r.getAttributeValue("", "code"));
                   concept.setDisplayName(r.getAttributeValue("", "displayName"));
                   concept.setCodeSystem(r.getAttributeValue("", "codeSystem"));
                   conceptList.addConcept(concept);
                }
            } else if (r.isEndElement()) {
                if ("ConceptList".equals(r.getLocalName())) {
                    break;
                }
            }
        }

    }
}
