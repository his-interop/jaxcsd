package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.FacilityDirectoryMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityDirectory implements CsdMarshalable {

    private List<Facility> facilities = new ArrayList<Facility>();
    private Marshaler<FacilityDirectory> marshaler = FacilityDirectoryMarshaler.get();

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public FacilityDirectory addFacility(Facility facility) {
        this.facilities.add(facility);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<FacilityDirectory> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<FacilityDirectory> marshaler) {
        this.marshaler = marshaler;
    }
    
    public boolean isEmpty() {
        return facilities == null || facilities.isEmpty();
    }
}
