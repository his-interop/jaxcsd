package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderOrganizationsMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizations implements CsdMarshalable {

    private List<ProviderOrganization> providerOrganizations = new ArrayList<ProviderOrganization>();
    private Marshaler<ProviderOrganizations> marshaler = ProviderOrganizationsMarshaler.get();

    public List<ProviderOrganization> getProviderOrganizations() {
        return providerOrganizations;
    }

    public void setProviderOrganizations(List<ProviderOrganization> providerOrganizations) {
        this.providerOrganizations = providerOrganizations;
    }

    public Marshaler<ProviderOrganizations> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<ProviderOrganizations> marshaler) {
        this.marshaler = marshaler;
    }

    public ProviderOrganizations addProviderOrganization(ProviderOrganization providerOrganization) {
        this.providerOrganizations.add(providerOrganization);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }
}
