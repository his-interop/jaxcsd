package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.PushRequestMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class PushRequest implements CsdMarshallable{
    
    private CSD csd;

    public CSD getCsd() {
        return csd;
    }

    public void setCsd(CSD csd) {
        this.csd = csd;
    }
    
    

    public String marshal() {
        return PushRequestMarshaller.get().marshal(this);
    }
    
}
