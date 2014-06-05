package zw.co.hitrac.jaxcsd.api.query;

import zw.co.hitrac.jaxcsd.api.domain.CsdMarshallable;
import zw.co.hitrac.jaxcsd.api.marshal.CareServicesRequestMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class CareServicesRequest implements CsdMarshallable{
    
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
        return CareServicesRequestMarshaller.get().marshal(this);
    }
    
    
    
}
