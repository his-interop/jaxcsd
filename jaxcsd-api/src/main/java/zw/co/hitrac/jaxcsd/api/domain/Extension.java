package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class Extension implements Serializable {

    private String type;
    private String oid;

    public Extension() {
    }

    public Extension(String type, String oid) {
        this.type = type;
        this.oid = oid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
