package zw.co.hitrac.jaxcsd.api.parser.ext;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.parser.ProviderExtensionParser;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class DefaultProviderExtensionParser extends ProviderExtensionParser{

    @Override
    public void parse(Provider provider,CsdElement extensionElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
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
