package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.FacilityOrganizationsMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizations implements CsdMarshalable{
    
    private List<FacilityOrganization> facilityOrganizations=new ArrayList<FacilityOrganization>();

    public List<FacilityOrganization> getFacilityOrganizations() {
        return facilityOrganizations;
    }

    public void setFacilityOrganizations(List<FacilityOrganization> facilityOrganizations) {
        this.facilityOrganizations = facilityOrganizations;
    }
    
    public FacilityOrganizations addFacilityOrganization(FacilityOrganization facilityOrganization){
        this.facilityOrganizations.add(facilityOrganization);
        return this;
    }

    public String marshal() {
        return FacilityOrganizationsMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return FacilityOrganizationsMarshaler.get().marshal(this, elementName);
    }

    
    


}
