package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.ServiceDirectoryMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceDirectory implements CsdMarshalable {

    private List<Service> services = new ArrayList<Service>();
    private Marshaler<ServiceDirectory> marshaler = ServiceDirectoryMarshaler.get();

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Marshaler<ServiceDirectory> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<ServiceDirectory> marshaler) {
        this.marshaler = marshaler;
    }

    public ServiceDirectory addService(Service service) {
        this.services.add(service);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public boolean isEmpty() {
        return services == null || services.isEmpty();
    }
}
