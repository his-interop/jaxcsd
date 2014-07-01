package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.parser.util.HandlerUtils;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Geocode;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class GeocodeParser extends AbstractCsdParser<Geocode> {

    @Override
    public void parse(final Geocode geocode, CsdElement geoCodeElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
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
                if (geoCodeElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }
}
