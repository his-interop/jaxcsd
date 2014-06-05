package zw.co.hitrac.jaxcsd.api.query;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */ 
public class Expression implements Serializable{
    
    private boolean encapsulated;
    private String contentType;

    public boolean isEncapsulated() {
        return encapsulated;
    }

    public void setEncapsulated(boolean encapsulated) {
        this.encapsulated = encapsulated;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    
    
}
