package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.OtherIDMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class OtherID implements CsdMarshalable{
    
    private String code;
    private String assigningAuthorityName;

    public OtherID() {
    }

    public OtherID(String code, String assigningAuthorityName) {
        this.code = code;
        this.assigningAuthorityName = assigningAuthorityName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAssigningAuthorityName() {
        return assigningAuthorityName;
    }

    public void setAssigningAuthorityName(String assigningAuthorityName) {
        this.assigningAuthorityName = assigningAuthorityName;
    }

    public String marshal() {
        return OtherIDMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return OtherIDMarshaler.get().marshal(this, elementName);
    }

  
}
