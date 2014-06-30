package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderFacilitiesMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilities implements CsdMarshalable {

    private List<ProviderFacility> providerFacilities = new ArrayList<ProviderFacility>();
    private Marshaler<ProviderFacilities> marshaler = ProviderFacilitiesMarshaler.get();

    public List<ProviderFacility> getProviderFacilities() {
        return providerFacilities;
    }

    public void setProviderFacilities(List<ProviderFacility> providerFacilities) {
        this.providerFacilities = providerFacilities;
    }

    public Marshaler<ProviderFacilities> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<ProviderFacilities> marshaler) {
        this.marshaler = marshaler;
    }

    public ProviderFacilities addProviderFacility(ProviderFacility providerFacility) {
        this.providerFacilities.add(providerFacility);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }
}
