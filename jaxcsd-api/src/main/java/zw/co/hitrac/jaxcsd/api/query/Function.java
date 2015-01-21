package zw.co.hitrac.jaxcsd.api.query;

import zw.co.hitrac.jaxcsd.api.domain.CsdMarshalable;
import zw.co.hitrac.jaxcsd.api.marshal.FunctionMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Function implements CsdMarshalable{
    
    private String urn;
    private boolean encapsulated;
    
    private RequestParams requestParams;

    public Function() {
    }

    public Function(String urn) {
        this.urn = urn;
    }

    public Function(String urn, RequestParams requestParams) {
        this.urn = urn;
        this.requestParams = requestParams;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
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

    public String marshal() {
       return FunctionMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return FunctionMarshaler.get().marshal(this, elementName);
    }
    
    
}
