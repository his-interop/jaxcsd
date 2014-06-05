package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganizations;
import zw.co.hitrac.jaxcsd.api.marshal.ext.ExtensionListMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationsMarshaller extends Marshaller<FacilityOrganizations> {

    private static final  FacilityOrganizationsMarshaller INSTANCE=new FacilityOrganizationsMarshaller();
        
    private FacilityOrganizationsMarshaller() {
    }
    
    

    @Override
    public String marshal(FacilityOrganizations facilityOrganizations) {
        StringBuilder sb = new StringBuilder();
        if (facilityOrganizations != null && facilityOrganizations.getFacilityOrganizations() != null && !facilityOrganizations.getFacilityOrganizations().isEmpty()) {
            sb.append("<organizations>");
            for (FacilityOrganization facilityOrganization : facilityOrganizations.getFacilityOrganizations()) {
                sb.append("<organization oid=\"").append(facilityOrganization.getOid()).append("\">");
                //TODO:: work on FacilityOrganizationServiceListMarshaller here !!!       
                sb.append(ExtensionListMarshaller.get().marshal(facilityOrganization.getExtensions()));
                sb.append("</organization>");
            }
            sb.append("</organizations>");
        }
        return sb.toString();
    }

    public static FacilityOrganizationsMarshaller get() {
        return INSTANCE;
    }    
    
}
