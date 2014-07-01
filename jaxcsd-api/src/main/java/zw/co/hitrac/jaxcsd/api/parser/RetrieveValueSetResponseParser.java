package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.svs.RetrieveValueSetResponse;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class RetrieveValueSetResponseParser extends AbstractCsdParser<RetrieveValueSetResponse> {

    private ValueSetParser valueSetParser=new ValueSetParser();
    
    @Override
    public void parse(final RetrieveValueSetResponse retrieveValueSetResponse, CsdElement retrieveValueSetResponseElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (retrieveValueSetResponseElement.elementEquals(r)) {
                    if (retrieveValueSetResponse != null) {
                        retrieveValueSetResponse.setId(r.getAttributeValue("", "id"));
                        retrieveValueSetResponse.setVersion(r.getAttributeValue("", "version"));
                    }
                } else if (VALUE_SET_ELEMENT.elementEquals(r)) {
                    if (retrieveValueSetResponse != null) {
                        ValueSet valueSet = new ValueSet();
                        valueSet.setId(r.getAttributeValue("", "id"));
                        valueSet.setVersion(r.getAttributeValue("", "version"));
                        valueSet.setDisplayName(r.getAttributeValue("", "displayName"));
                        retrieveValueSetResponse.addValueSet(valueSet);
                        valueSetParser.parse(valueSet, VALUE_SET_ELEMENT, r, csdParserExtensions);
                    }
                }
            } else if (r.isEndElement()) {
                if (retrieveValueSetResponseElement.elementEquals(r)) {
                    break;
                }
            }

        }
    }

    public void setValueSetParser(ValueSetParser valueSetParser) {
        this.valueSetParser = valueSetParser;
    }
    
    
    
    public static final  CsdElement VALUE_SET_ELEMENT=new CsdElement(CsdElementConstants.VALUE_SET);
}
