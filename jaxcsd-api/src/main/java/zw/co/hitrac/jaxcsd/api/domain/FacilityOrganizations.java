package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizations implements Serializable{
    
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

    
    


}
