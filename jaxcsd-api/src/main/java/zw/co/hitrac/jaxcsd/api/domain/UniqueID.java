package zw.co.hitrac.jaxcsd.api.domain;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class UniqueID implements CsdMarshalable{
    
    protected String entityID;

    public UniqueID() {
    }

    public UniqueID(String entityID) {
        this.entityID = entityID;
    }
    
    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

   
    
    
}
