package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacility;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilityParser extends AbstractCsdParser<ProviderFacility> {
    
    
    @Override
    public void parse(ProviderFacility providerFacility, CsdElement providerFacilityElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                //TODO: to add other handlers
            }else if (r.isEndElement()) {
                if (providerFacilityElement.elementEquals(r)) {
                    break;
                }
            }
         }
    }
    
}
