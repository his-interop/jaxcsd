package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.FacilityOrganizationsMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizations implements CsdMarshalable {

    private List<FacilityOrganization> facilityOrganizations = new ArrayList<FacilityOrganization>();
    private Marshaler<FacilityOrganizations> marshaler = FacilityOrganizationsMarshaler.get();

    public List<FacilityOrganization> getFacilityOrganizations() {
        return facilityOrganizations;
    }

    public void setFacilityOrganizations(List<FacilityOrganization> facilityOrganizations) {
        this.facilityOrganizations = facilityOrganizations;
    }

    public FacilityOrganizations addFacilityOrganization(FacilityOrganization facilityOrganization) {
        this.facilityOrganizations.add(facilityOrganization);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<FacilityOrganizations> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<FacilityOrganizations> marshaler) {
        this.marshaler = marshaler;
    }
}
