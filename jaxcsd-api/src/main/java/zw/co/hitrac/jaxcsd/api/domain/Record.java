package zw.co.hitrac.jaxcsd.api.domain;

import java.util.Date;
import zw.co.hitrac.jaxcsd.api.marshal.RecordMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Record implements CsdMarshalable{
    
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

    public String marshal() {
       return RecordMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return RecordMarshaler.get().marshal(this, elementName);
    }
    
    
}
