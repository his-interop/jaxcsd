package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.xp.*;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderDirectoryParser extends AbstractCsdParser<ProviderDirectory>{

    public void parse(ProviderDirectory providerDirectory, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        if (providerDirectory != null) {
            while (r.hasNext()) {
                r.next();

                if (r.isStartElement()) {
                    if ("provider".equals(r.getLocalName())) {
                        Provider provider = new Provider();
                        provider.setOid(r.getAttributeValue("", "oid"));
                        providerDirectory.getProviders().add(provider);
                        ProviderHandler.handle(provider, r);
                    }


                } else if (r.isEndElement()) {
                    if ("providerDirectory".equals(r.getLocalName())) {
                        break;
                    }
                }
            }
        }
    }
}
