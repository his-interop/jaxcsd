package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderFacilitiesMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilities implements CsdMarshalable{
    
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

    public String marshal() {
        return ProviderFacilitiesMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return ProviderFacilitiesMarshaler.get().marshal(this, elementName);
    }
    
}
