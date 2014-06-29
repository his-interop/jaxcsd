package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderOrganizationsMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizations implements CsdMarshalable {

    private List<ProviderOrganization> providerOrganizations = new ArrayList<ProviderOrganization>();

    public List<ProviderOrganization> getProviderOrganizations() {
        return providerOrganizations;
    }

    public void setProviderOrganizations(List<ProviderOrganization> providerOrganizations) {
        this.providerOrganizations = providerOrganizations;
    }
    
    public ProviderOrganizations addProviderOrganization(ProviderOrganization providerOrganization){
        this.providerOrganizations.add(providerOrganization);
        return this;
    }

    public String marshal() {
       return ProviderOrganizationsMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return ProviderOrganizationsMarshaler.get().marshal(this, elementName);
    }
}
