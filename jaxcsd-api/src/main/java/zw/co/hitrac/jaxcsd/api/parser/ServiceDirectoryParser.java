package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceDirectoryParser extends AbstractCsdParser<ServiceDirectory> {

    private ServiceParser serviceParser=new ServiceParser();

    public void parse(ServiceDirectory serviceDirectory, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if ("service".equals(r.getLocalName())) {
                    Service service=new Service();
                    service.setOid(r.getAttributeValue("", "oid"));
                    serviceDirectory.getServices().add(service);
                     serviceParser.parse(service, r, csdParserExtensions);
                }
            } else if (r.isEndElement()) {
                if ("serviceDirectory".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }

    public ServiceParser getServiceParser() {
        return serviceParser;
    }
   
}
