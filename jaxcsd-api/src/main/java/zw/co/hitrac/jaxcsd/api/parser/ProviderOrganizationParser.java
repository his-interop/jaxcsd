package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizationParser extends AbstractCsdParser<ProviderOrganization>{
    
    public static void handle(ProviderOrganization providerOrganization, XMLStreamReader r) throws XMLStreamException {
       

     }

    @Override
    public void parse(ProviderOrganization providerOrganization, CsdElement providerOrganizationElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
         while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                //TODO: to add other handlers
            }else if (r.isEndElement()) {
                if (providerOrganizationElement.elementEquals(r)) {
                    break;
                }
            }
         }
    }
    
}
