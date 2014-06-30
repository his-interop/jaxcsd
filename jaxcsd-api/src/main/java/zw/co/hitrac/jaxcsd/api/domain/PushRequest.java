package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.PushRequestMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class PushRequest implements CsdMarshalable {

    private CSD csd;
    private Marshaler<PushRequest> marshaler = PushRequestMarshaler.get();

    public CSD getCsd() {
        return csd;
    }

    public void setCsd(CSD csd) {
        this.csd = csd;
    }

    public Marshaler<PushRequest> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<PushRequest> marshaler) {
        this.marshaler = marshaler;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }
}
