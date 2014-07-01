package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.OperatingHours;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class OperatingHoursParser extends AbstractCsdParser<OperatingHours>{    
    
    @Override
    public void parse(OperatingHours operatingHours, CsdElement operatingHoursElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
           while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                //TODO:: To add operating hours elements later!
            } else if (r.isEndElement()) {
                if (operatingHoursElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }
}
