package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationMarshaler extends Marshaler<FacilityOrganization> {
    
    private static final FacilityOrganizationMarshaler INSTANCE=new FacilityOrganizationMarshaler();

    @Override
    public String marshal(FacilityOrganization facilityOrganization) {
        return marshal(facilityOrganization, ORGANIZATION);
    }

    @Override
    public String marshal(FacilityOrganization facilityOrganization, String elementName) {
        StringBuilder sb=new StringBuilder();
        sb.append("<").append(elementName).append(" entityID=\"").append(facilityOrganization.getEntityID()).append("\">");
        //TODO:: work on FacilityOrganizationServiceListMarshaller here !!!       
        sb.append(ExtensionListMarshaller.get().marshal(facilityOrganization.getExtensions()));
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    public static FacilityOrganizationMarshaler get() {
        return INSTANCE;
    }
    
    
}
