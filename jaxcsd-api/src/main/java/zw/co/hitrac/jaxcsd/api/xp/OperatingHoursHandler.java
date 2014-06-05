package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.OperatingHours;

/**
 *
 * @author Charles Chigoriwa
 */
public class OperatingHoursHandler {

    public static void handle(OperatingHours operatingHours, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                //TODO:: To add operating hours elements later!
            } else if (r.isEndElement()) {
                if ("operatingHours".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
