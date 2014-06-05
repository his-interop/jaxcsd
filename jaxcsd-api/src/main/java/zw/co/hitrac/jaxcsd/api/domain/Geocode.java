package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Charles Chigoriwa
 */
public class Geocode implements Serializable{
    
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal altitude;
    private String coordinateSystem;

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
    
    
}
