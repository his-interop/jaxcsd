package zw.co.hitrac.jaxcsd.api.domain;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class UniqueID implements CsdMarshalable{
    
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
