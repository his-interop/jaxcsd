package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderDirectoryMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderDirectory implements CsdMarshallable{
    
    private List<Provider> providers=new ArrayList<Provider>();

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }
    
    public ProviderDirectory addProvider(Provider provider){
        this.providers.add(provider);
        return this;
    }
    
    

    public String marshal() {
       return ProviderDirectoryMarshaller.get().marshal(this);
    }
    
}
