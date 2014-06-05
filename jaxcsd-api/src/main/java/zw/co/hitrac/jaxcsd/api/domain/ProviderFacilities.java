package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilities implements Serializable{
    
    private List<ProviderFacility> providerFacilities=new ArrayList<ProviderFacility>();

    public List<ProviderFacility> getProviderFacilities() {
        return providerFacilities;
    }

    public void setProviderFacilities(List<ProviderFacility> providerFacilities) {
        this.providerFacilities = providerFacilities;
    }
    
    public ProviderFacilities addProviderFacility(ProviderFacility providerFacility){
        this.providerFacilities.add(providerFacility);
        return this;
    }
    
}
