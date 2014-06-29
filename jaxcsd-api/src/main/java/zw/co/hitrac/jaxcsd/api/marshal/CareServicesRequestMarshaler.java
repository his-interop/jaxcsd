package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.query.CareServicesRequest;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class CareServicesRequestMarshaler extends Marshaler<CareServicesRequest> {

    private static final CareServicesRequestMarshaler INSTANCE = new CareServicesRequestMarshaler();

    private CareServicesRequestMarshaler() {
    }

    @Override
    public String marshal(CareServicesRequest careServicesRequest, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<csd:").append(elementName).append(" xmlns:csd='urn:ihe:iti:csd:2013' xmlns='urn:ihe:iti:csd:2013'>");
        if (careServicesRequest.getFunction() != null) {
            sb.append(careServicesRequest.getFunction().marshal());
        } else if (careServicesRequest.getExpression() != null) {
            //TODO: work on adhoc expression marshaller later (since it's optional)
        }
        sb.append("</csd:").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(CareServicesRequest careServicesRequest) {
        return marshal(careServicesRequest, CARE_SERVICES_REQUEST);
    }

    public static CareServicesRequestMarshaler get() {
        return INSTANCE;
    }
}
