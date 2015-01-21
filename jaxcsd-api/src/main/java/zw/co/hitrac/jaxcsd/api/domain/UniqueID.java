package zw.co.hitrac.jaxcsd.api.domain;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class UniqueID implements CsdMarshalable {

    protected String entityID;

    public UniqueID() {
    }

    public UniqueID(String entityID) {
        this.entityID = entityID;
    }

    public String getEntityID() {
        return entityID;
    }

    /**
     *
     * @param entityID
     *
     * Should be a valid UUID represented as an URN. Example:
     * "urn:uuid:53347B2E-185E-4BC3-BCDA-7FAB5D521FE7"
     */
    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

}
