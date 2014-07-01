package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationContact;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationContactParser extends AbstractCsdParser<OrganizationContact>{
    
    
    @Override
    public void parse(OrganizationContact organizationContact, CsdElement organizationContactElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
       while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                //TODO: to deal with inner handlers later!
            }else if (r.isEndElement()) {
                if (organizationContactElement.elementEquals(r)) {
                    break;
                }
            }
         }
    }
}
