package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.domain.ext.ServiceExtension;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceHandler {

    public static void handle(Service service, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if("codedType".equals(r.getLocalName())){
                    CodedType codedType=HandlerUtils.getCodedType(r);
                    service.getCodedTypes().add(codedType);
                }else if("extension".equals(r.getLocalName())){
                    ServiceExtension extension=new ServiceExtension();
                    service.getExtensions().add(extension);
                    ExtensionHandler.handle(extension, r);
                }else if("record".equals(r.getLocalName())){
                    Record record=HandlerUtils.getRecord(r);
                    service.setRecord(record);
                }
            } else if (r.isEndElement()) {
                if ("service".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
