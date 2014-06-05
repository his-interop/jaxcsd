package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.ServiceMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class Service extends CsdEntity{

    public String marshal() {
        return ServiceMarshaller.get().marshal(this);
    }
    
   
}
