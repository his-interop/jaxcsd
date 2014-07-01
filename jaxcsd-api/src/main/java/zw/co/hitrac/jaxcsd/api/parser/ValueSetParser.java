package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class ValueSetParser extends AbstractCsdParser<ValueSet> {
    
    private ConceptListParser conceptListParser=new ConceptListParser();

    @Override
    public void parse(ValueSet valueSet, CsdElement valueSetElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (CONCEPT_LIST_ELEMENT.elementEquals(r)) {
                    ConceptList conceptList=new ConceptList();
                    conceptList.setLang(r.getAttributeValue("", "xml:lang"));
                    valueSet.addConceptList(conceptList);
                    conceptListParser.parse(conceptList, CONCEPT_LIST_ELEMENT, r, csdParserExtensions);
                }       
            } else if (r.isEndElement()) {
                if (valueSetElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    public void setConceptListParser(ConceptListParser conceptListParser) {
        this.conceptListParser = conceptListParser;
    }
    
    
    
    public static final CsdElement CONCEPT_LIST_ELEMENT=new CsdElement(CsdElementConstants.CONCEPT_LIST);
    
}
