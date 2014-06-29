package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Geocode;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class GeocodeMarshaler extends Marshaler<Geocode> {

    private static final GeocodeMarshaler INSTANCE = new GeocodeMarshaler();

    private GeocodeMarshaler() {
    }

    @Override
    public String marshal(Geocode geocode, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (geocode != null && geocode.getLatitude() != null && geocode.getLongitude() != null) {
            sb.append("<").append(elementName).append(">");
            sb.append(getInlineXmlElement("latitude", geocode.getLatitude().toString()));
            sb.append(getInlineXmlElement("longitude", geocode.getLongitude().toString()));
            if (geocode.getAltitude() != null) {
                sb.append(getInlineXmlElement("altitude", geocode.getAltitude().toString()));
            }

            if (geocode.getCoordinateSystem() != null) {
                sb.append(getInlineXmlElement("coordinateSystem", geocode.getCoordinateSystem()));
            }

            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();
    }

    @Override
    public String marshal(Geocode geocode) {
        return marshal(geocode, GEOCODE);
    }

    public static GeocodeMarshaler get() {
        return INSTANCE;
    }
}
