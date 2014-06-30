package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.xp.*;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderDirectoryParser extends AbstractCsdParser<ProviderDirectory>{
    
    public static final CsdElement providerElement=new CsdElement(PROVIDER);
            

    public void parse(ProviderDirectory providerDirectory,CsdElement providerDirectoryElement,  XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        if (providerDirectory != null) {
            while (r.hasNext()) {
                r.next();
                if (r.isStartElement()) {
                    if (providerElement.elementEquals(r)) {
                        Provider provider = new Provider();
                        provider.setOid(r.getAttributeValue("", "oid"));
                        providerDirectory.getProviders().add(provider);
                        ProviderHandler.handle(provider, r);
                    }


                } else if (r.isEndElement()) {
                    if (providerDirectoryElement.elementEquals(r)) {
                        break;
                    }
                }
            }
        }
    }
}
