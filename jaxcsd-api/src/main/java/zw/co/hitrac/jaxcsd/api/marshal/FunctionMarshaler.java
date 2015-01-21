package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.query.Function;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class FunctionMarshaler extends Marshaler<Function> {

    private static final FunctionMarshaler INSTANCE = new FunctionMarshaler();

    private FunctionMarshaler() {
    }

    @Override
    public String marshal(Function function, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(" urn=\"").append(function.getUrn()).append("\">");
        sb.append(function.getRequestParams().marshal());
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(Function function) {
        return marshal(function, FUNCTION);
    }

    public static FunctionMarshaler get() {
        return INSTANCE;
    }
}
