package zw.co.hitrac.jaxcsd.api.util;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public class JaxcsdResponse implements Serializable{
    
    private int statusCode;
    private String reasonPhrase;
    private String body;

    public JaxcsdResponse() {
    }

    public JaxcsdResponse(int statusCode, String reasonPhrase, String body) {
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.body = body;
    }
    

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }
    

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "JaxcsdResponse{" + "statusCode=" + statusCode + ", reasonPhrase=" + reasonPhrase + '}';
    }
}
