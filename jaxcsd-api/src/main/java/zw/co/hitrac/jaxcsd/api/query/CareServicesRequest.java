package zw.co.hitrac.jaxcsd.api.query;

import zw.co.hitrac.jaxcsd.api.domain.CsdMarshalable;
import zw.co.hitrac.jaxcsd.api.marshal.CareServicesRequestMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class CareServicesRequest implements CsdMarshalable{
    
    private Function function;
    private Expression expression;

    public CareServicesRequest() {
    }
    
    

    public CareServicesRequest(Function function) {
        this.function = function;
    }

    public CareServicesRequest(Expression expression) {
        this.expression = expression;
    }
    
    

    public Function getFunction() {
        return function;
    }

    public Expression getExpression() {
        return expression;
    }

    public String marshal() {
        return CareServicesRequestMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return CareServicesRequestMarshaler.get().marshal(this, elementName);
    }
    
    
    
}
