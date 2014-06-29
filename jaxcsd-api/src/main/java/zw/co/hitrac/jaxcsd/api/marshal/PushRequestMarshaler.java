package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.PushRequest;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class PushRequestMarshaler extends Marshaler<PushRequest> {

    private static final PushRequestMarshaler INSTANCE = new PushRequestMarshaler();

    @Override
    public String marshal(PushRequest pushRequest, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(">");
        sb.append(pushRequest.getCsd().marshal());
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(PushRequest pushRequest) {
        return marshal(pushRequest, PUSH_REQUEST);
    }

    public static PushRequestMarshaler get() {
        return INSTANCE;
    }
}
