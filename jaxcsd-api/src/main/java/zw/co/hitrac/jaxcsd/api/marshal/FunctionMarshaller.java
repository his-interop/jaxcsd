package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.query.Function;

/**
 *
 * @author Charles Chigoriwa
 */
public class FunctionMarshaller extends Marshaller<Function>{
    
    private static final FunctionMarshaller INSTANCE=new FunctionMarshaller();

    private FunctionMarshaller() {
    }
    
    

    @Override
    public String marshal(Function function) {
        StringBuilder sb=new StringBuilder();
        sb.append("<function uuid=\"").append(function.getUuid()).append("\">");
        sb.append(RequestParamsMarshaller.get().marshal(function.getRequestParams()));
        sb.append("</function>");
        return sb.toString();
    }

    public static FunctionMarshaller get() {
        return INSTANCE;
    }
    
    
    
}
