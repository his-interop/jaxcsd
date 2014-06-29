package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganizations;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationsMarshaler extends Marshaler<FacilityOrganizations> {

    private static final FacilityOrganizationsMarshaler INSTANCE = new FacilityOrganizationsMarshaler();

    private FacilityOrganizationsMarshaler() {
    }

    @Override
    public String marshal(FacilityOrganizations facilityOrganizations, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (facilityOrganizations != null && facilityOrganizations.getFacilityOrganizations() != null && !facilityOrganizations.getFacilityOrganizations().isEmpty()) {
            sb.append("<").append(elementName).append(">");
            for (FacilityOrganization facilityOrganization : facilityOrganizations.getFacilityOrganizations()) {
                sb.append(facilityOrganization.marshal());
            }
            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();
    }

    @Override
    public String marshal(FacilityOrganizations facilityOrganizations) {
        return marshal(facilityOrganizations, ORGANIZATIONS);
    }

    public static FacilityOrganizationsMarshaler get() {
        return INSTANCE;
    }
}
