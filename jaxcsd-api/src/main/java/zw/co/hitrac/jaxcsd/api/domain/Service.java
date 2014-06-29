package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.ServiceMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Service extends CsdEntity{

    public String marshal() {
        return ServiceMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return ServiceMarshaler.get().marshal(this, elementName);
    }
    
   
}
