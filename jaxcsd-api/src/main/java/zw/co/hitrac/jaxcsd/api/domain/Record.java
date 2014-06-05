package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Charles Chigoriwa
 */
public class Record implements Serializable{
    
    private Date created;
    private Date updated;
    private String status;
    private String sourceDirectory;

    public Record() {
    }
    
    

    public Record(Date created, Date updated, String status) {
        this.created = created;
        this.updated = updated;
        this.status = status;
    }
    
    

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }
    
    
}
