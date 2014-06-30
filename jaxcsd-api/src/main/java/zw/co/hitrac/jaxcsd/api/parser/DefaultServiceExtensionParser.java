package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class DefaultServiceExtensionParser extends ServiceExtensionParser {

    @Override
    public void parse(Service service,CsdElement extensionElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
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
