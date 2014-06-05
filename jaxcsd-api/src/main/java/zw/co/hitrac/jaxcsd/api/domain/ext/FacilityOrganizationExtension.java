package zw.co.hitrac.jaxcsd.api.domain.ext;

import zw.co.hitrac.jaxcsd.api.domain.Extension;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationExtension extends Extension{
    
    private String organizationName;

    public FacilityOrganizationExtension() {
    }

    public FacilityOrganizationExtension(String organizationName) {
        this.organizationName = organizationName;
    }
    
    

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    
    
}
