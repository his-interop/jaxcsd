package zw.co.hitrac.jaxcsd.api.query;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public class Function implements Serializable{
    
    private String uuid;
    private boolean encapsulated;
    
    private RequestParams requestParams;

    public Function() {
    }

    public Function(String uuid) {
        this.uuid = uuid;
    }

    public Function(String uuid, RequestParams requestParams) {
        this.uuid = uuid;
        this.requestParams = requestParams;
    }
    
    

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public RequestParams getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(RequestParams requestParams) {
        this.requestParams = requestParams;
    }

    public boolean isEncapsulated() {
        return encapsulated;
    }

    public void setEncapsulated(boolean encapsulated) {
        this.encapsulated = encapsulated;
    }
    
    
}
