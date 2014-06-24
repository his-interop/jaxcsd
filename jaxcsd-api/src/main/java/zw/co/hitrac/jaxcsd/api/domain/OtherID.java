package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public class OtherID implements Serializable{
    
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

  
}
