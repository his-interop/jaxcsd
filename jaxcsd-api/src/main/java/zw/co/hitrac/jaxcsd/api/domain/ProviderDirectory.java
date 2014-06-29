package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderDirectoryMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderDirectory implements CsdMarshalable {

    private List<Provider> providers = new ArrayList<Provider>();

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public ProviderDirectory addProvider(Provider provider) {
        this.providers.add(provider);
        return this;
    }

    public String marshal() {
        return ProviderDirectoryMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return ProviderDirectoryMarshaler.get().marshal(this, elementName);
    }
}
