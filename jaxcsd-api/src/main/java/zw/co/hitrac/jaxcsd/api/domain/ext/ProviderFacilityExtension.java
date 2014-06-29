package zw.co.hitrac.jaxcsd.api.domain.ext;

import zw.co.hitrac.jaxcsd.api.domain.Extension;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilityExtension extends Extension{
    
    private String facilityName;

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String marshal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String marshal(String elementName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
