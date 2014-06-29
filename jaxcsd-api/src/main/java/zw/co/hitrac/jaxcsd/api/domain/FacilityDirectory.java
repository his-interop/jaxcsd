package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.FacilityDirectoryMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityDirectory implements CsdMarshalable{
    
    private List<Facility> facilities=new ArrayList<Facility>();

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
    
    public FacilityDirectory addFacility(Facility facility){
        this.facilities.add(facility);
        return this;
    }
    
    public String marshal() {
        return FacilityDirectoryMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return FacilityDirectoryMarshaler.get().marshal(this,elementName);
    }
    
}
