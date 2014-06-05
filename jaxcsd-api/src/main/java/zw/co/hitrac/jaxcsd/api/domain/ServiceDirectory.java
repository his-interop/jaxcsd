package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ServiceDirectoryMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceDirectory implements CsdMarshallable{
    
    private List<Service> services=new ArrayList<Service>();

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    
    public ServiceDirectory addService(Service service){
        this.services.add(service);
        return this;
    }
    

    public String marshal() {
        return ServiceDirectoryMarshaller.get().marshal(this);
    }
    
}
