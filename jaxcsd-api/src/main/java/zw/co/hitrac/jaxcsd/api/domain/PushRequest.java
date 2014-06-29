package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.PushRequestMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class PushRequest implements CsdMarshalable{
    
    private CSD csd;

    public CSD getCsd() {
        return csd;
    }

    public void setCsd(CSD csd) {
        this.csd = csd;
    }
    
    

    public String marshal() {
        return PushRequestMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return PushRequestMarshaler.get().marshal(this, elementName);
    }
    
}
