package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.xp.*;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceParser extends AbstractCsdParser<Service> {

    private DefaultServiceExtensionParser defaultServiceExtensionParser = new DefaultServiceExtensionParser();

    public void parse(Service service, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("codedType".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    service.getCodedTypes().add(codedType);
                } else if ("extension".equals(r.getLocalName())) {
                    if (csdParserExtensions != null && csdParserExtensions.getServiceExtensionParser() != null) {
                        csdParserExtensions.getServiceExtensionParser().parse(service, r, csdParserExtensions);
                    } else {
                        this.defaultServiceExtensionParser.parse(service, r, csdParserExtensions);
                    }
                } else if ("record".equals(r.getLocalName())) {
                    Record record = HandlerUtils.getRecord(r);
                    service.setRecord(record);
                }



            } else if (r.isEndElement()) {
                if ("service".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }

    public void setDefaultServiceExtensionParser(DefaultServiceExtensionParser defaultServiceExtensionParser) {
        this.defaultServiceExtensionParser = defaultServiceExtensionParser;
    }
}
