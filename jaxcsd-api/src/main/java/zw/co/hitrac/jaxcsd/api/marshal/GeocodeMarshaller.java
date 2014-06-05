package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Geocode;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class GeocodeMarshaller extends Marshaller<Geocode> {
    
    private static final GeocodeMarshaller INSTANCE=new GeocodeMarshaller();

    private GeocodeMarshaller() {
    }
    
    

    @Override
    public String marshal(Geocode geocode) {
        StringBuilder sb = new StringBuilder();
        if (geocode != null && geocode.getLatitude() != null && geocode.getLongitude() != null) {
            sb.append("<geocode>");
            sb.append(getInlineXmlElement("latitude", geocode.getLatitude().toString()));
            sb.append(getInlineXmlElement("longitude", geocode.getLongitude().toString()));
            if (geocode.getAltitude() != null) {
                sb.append(getInlineXmlElement("altitude", geocode.getAltitude().toString()));
            }

            if (geocode.getCoordinateSystem() != null) {
                sb.append(getInlineXmlElement("coordinateSystem", geocode.getCoordinateSystem()));
            }

            sb.append("</geocode>");
        }
        return sb.toString();
    }

    public static GeocodeMarshaller get() {
        return INSTANCE;
    }
}
