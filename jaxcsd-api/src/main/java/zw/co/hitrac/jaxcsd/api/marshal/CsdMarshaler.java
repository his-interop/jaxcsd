package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdMarshaler extends Marshaler<CSD> {

    private static final CsdMarshaler INSTANCE = new CsdMarshaler();

    public CsdMarshaler() {
    }

    @Override
    public String marshal(CSD csd, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(" xmlns=\"urn:ihe:iti:csd:2013\">");

        if (csd.getOrganizationDirectory() != null) {
            sb.append(csd.getOrganizationDirectory().marshal());
        } else {
            sb.append(MessageConstants.EMPTY_ORGANIZATION_DIRECTORY);
        }

        if (csd.getServiceDirectory() != null) {
            sb.append(csd.getServiceDirectory().marshal());
        } else {
            sb.append(MessageConstants.EMPTY_SERVICE_DIRECTORY);
        }

        if (csd.getFacilityDirectory() != null) {
            sb.append(csd.getFacilityDirectory().marshal());
        } else {
            sb.append(MessageConstants.EMPTY_FACILITY_DIRECTORY);
        }

        if (csd.getProviderDirectory() != null) {
            sb.append(csd.getProviderDirectory().marshal());
        } else {
            sb.append(MessageConstants.EMPTY_PROVIDER_DIRECTORY);
        }

        sb.append("</").append(elementName).append(">");
        return sb.toString();

    }

    @Override
    public String marshal(CSD csd) {
        return marshal(csd, CSD);
    }

    public static CsdMarshaler get() {
        return INSTANCE;
    }
}
