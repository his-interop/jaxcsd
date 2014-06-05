package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class UniqueID implements Serializable{
    
    protected String oid;

    public UniqueID() {
    }

    public UniqueID(String oid) {
        this.oid = oid;
    }
    
    

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
    
    
}
