package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceDirectoryParser extends AbstractCsdParser<ServiceDirectory> {
    
    private ServiceParser serviceParser = new ServiceParser();    
    public static final CsdElement serviceElement = new CsdElement(CsdElementConstants.SERVICE);
    
    public void parse(ServiceDirectory serviceDirectory, CsdElement serviceDirectoryElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (serviceElement.localElementEquals(r)) {
                    Service service = new Service();
                    service.setOid(r.getAttributeValue("", "oid"));
                    serviceDirectory.getServices().add(service);
                    serviceParser.parse(service, serviceElement, r, csdParserExtensions);
                }
            } else if (r.isEndElement()) {
                if (serviceDirectoryElement.localElementEquals(r)) {
                    break;
                }
            }
        }
    }
    
    public ServiceParser getServiceParser() {
        return serviceParser;
    }
}
