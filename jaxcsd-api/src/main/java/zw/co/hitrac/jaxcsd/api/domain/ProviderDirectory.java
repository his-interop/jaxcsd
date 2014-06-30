package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderDirectoryMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderDirectory implements CsdMarshalable {

    private List<Provider> providers = new ArrayList<Provider>();
    private Marshaler<ProviderDirectory> marshaler = ProviderDirectoryMarshaler.get();

    public List<Provider> getProviders() {
        return providers;
    }

    public Marshaler<ProviderDirectory> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<ProviderDirectory> marshaler) {
        this.marshaler = marshaler;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public ProviderDirectory addProvider(Provider provider) {
        this.providers.add(provider);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public boolean isEmpty() {
        return providers == null || providers.isEmpty();
    }
}
