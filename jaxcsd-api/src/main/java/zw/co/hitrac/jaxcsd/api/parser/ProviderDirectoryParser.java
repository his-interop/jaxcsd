package zw.co.hitrac.jaxcsd.api.parser;

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
    
    private ProviderParser providerParser=new ProviderParser();
    
    public static final CsdElement PROVIDER_ELEMENT=new CsdElement(PROVIDER);
    
    
            

    public void parse(ProviderDirectory providerDirectory,CsdElement providerDirectoryElement,  XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        if (providerDirectory != null) {
            while (r.hasNext()) {
                r.next();
                if (r.isStartElement()) {
                    if (PROVIDER_ELEMENT.elementEquals(r)) {
                        Provider provider = new Provider();
                        provider.setOid(r.getAttributeValue("", "oid"));
                        providerDirectory.getProviders().add(provider);
                        providerParser.parse(provider, PROVIDER_ELEMENT, r, csdParserExtensions);
                    }


                } else if (r.isEndElement()) {
                    if (providerDirectoryElement.elementEquals(r)) {
                        break;
                    }
                }
            }
        }
    }

    public void setProviderParser(ProviderParser providerParser) {
        this.providerParser = providerParser;
    }
    
    
}
