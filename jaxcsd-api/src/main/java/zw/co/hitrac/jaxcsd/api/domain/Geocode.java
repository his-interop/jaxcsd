package zw.co.hitrac.jaxcsd.api.domain;

import java.math.BigDecimal;
import zw.co.hitrac.jaxcsd.api.marshal.GeocodeMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Geocode implements CsdMarshalable {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal altitude;
    private String coordinateSystem;
    private Marshaler<Geocode> marshaler = GeocodeMarshaler.get();

    public Geocode() {
    }

    public Geocode(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Geocode(BigDecimal latitude, BigDecimal longitude, BigDecimal altitude, String coordinateSystem) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.coordinateSystem = coordinateSystem;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<Geocode> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<Geocode> marshaler) {
        this.marshaler = marshaler;
    }
}
