package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.FacilityMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Facility extends AbstractOrganization {

    public Facility() {
    }

    public Facility(String oid) {
        this.oid=oid;
    }
    
    
    
    
    private FacilityOrganizations facilityOrganizations=new FacilityOrganizations();
    private List<OperatingHours> operatingHours=new ArrayList<OperatingHours>();
    private Geocode geocode;
    

    public FacilityOrganizations getFacilityOrganizations() {
        return facilityOrganizations;
    }

    public void setFacilityOrganizations(FacilityOrganizations facilityOrganizations) {
        this.facilityOrganizations = facilityOrganizations;
    }

    public List<OperatingHours> getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(List<OperatingHours> operatingHours) {
        this.operatingHours = operatingHours;
    }

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }
    
    public Facility addFacilityOrganization(FacilityOrganization facilityOrganization){
        if(facilityOrganizations==null){
            facilityOrganizations=new FacilityOrganizations();
        }
        
        facilityOrganizations.addFacilityOrganization(facilityOrganization);
        return this;
    }
    
        
  
    public String marshal() {
       return FacilityMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return FacilityMarshaler.get().marshal(this,elementName);
    }

}
