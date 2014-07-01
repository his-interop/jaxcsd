package zw.co.hitrac.jaxcsd.api.parser.ext;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.parser.OrganizationExtensionParser;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class DefaultOrganizationExtensionParser extends OrganizationExtensionParser {

    @Override
    public void parse(Organization organization,CsdElement extensionElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isEndElement()) {
                if (extensionElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }
}
