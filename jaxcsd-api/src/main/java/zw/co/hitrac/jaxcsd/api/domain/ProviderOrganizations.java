package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizations implements Serializable {

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
}
