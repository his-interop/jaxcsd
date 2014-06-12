package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.svs.RetrieveValueSetResponse;

/**
 *
 * @author Charles Chigoriwa
 */
public class ValueSetHandler {

    public static void handle(ValueSet valueSet, XMLStreamReader r) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                String localName = r.getLocalName();
                if ("ConceptList".equals(localName)) {
                    ConceptList conceptList=new ConceptList();
                    conceptList.setLang(r.getAttributeValue("", "xml:lang"));
                    valueSet.addConceptList(conceptList);
                    ConceptListHandler.handle(conceptList, r);
                }       
            } else if (r.isEndElement()) {
                if ("ValueSet".equals(r.getLocalName())) {
                    break;
                }
            }
        }

    }
    
}
