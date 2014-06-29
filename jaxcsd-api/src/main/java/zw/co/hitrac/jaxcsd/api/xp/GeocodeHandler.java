package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Geocode;

/**
 *
 * @author Charles Chigoriwa
 */
public class GeocodeHandler {

    public static void handle(Geocode geocode, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("latitude".equals(r.getLocalName())) {
                    geocode.setLatitude(HandlerUtils.getBigDecimal(r));
                } else if ("longitude".equals(r.getLocalName())) {
                    geocode.setLongitude(HandlerUtils.getBigDecimal(r));
                } else if ("altitude".equals(r.getLocalName())) {
                    geocode.setAltitude(HandlerUtils.getBigDecimal(r));
                } else if ("coordinateSystem".equals(r.getLocalName())) {
                    geocode.setCoordinateSystem(HandlerUtils.getCharacters(r));
                }
            } else if (r.isEndElement()) {
                if ("geocode".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
