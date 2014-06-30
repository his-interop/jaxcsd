package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.ServiceMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Service extends CsdEntity{
    
    private Marshaler<Service> marsheler = ServiceMarshaler.get();

    public Marshaler<Service> getMarsheler() {
        return marsheler;
    }

    public void setMarsheler(Marshaler<Service> marsheler) {
        this.marsheler = marsheler;
    }

    public String marshal() {
        return marsheler.marshal(this);
    }

    public String marshal(String elementName) {
        return marsheler.marshal(this, elementName);
    }
    
   
}
