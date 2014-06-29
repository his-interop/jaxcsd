package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class DefaultProviderExtensionParser extends ProviderExtensionParser{

    @Override
    public void parse(Provider provider, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
         while (r.hasNext()) {
            r.next();
            if (r.isEndElement()) {
                if (EXTENSION.equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
    
}
