package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityDirectoryMarshaller extends Marshaller<FacilityDirectory> {
    
    private static final FacilityDirectoryMarshaller INSTANCE=new FacilityDirectoryMarshaller();

    private FacilityDirectoryMarshaller() {
    }
    
    

    @Override
    public String marshal(FacilityDirectory facilityDirectory) {
        StringBuilder sb = new StringBuilder();
        if (facilityDirectory != null && facilityDirectory.getFacilities() != null && !facilityDirectory.getFacilities().isEmpty()) {
            sb.append("<facilityDirectory>");
            for (Facility facility : facilityDirectory.getFacilities()) {
                sb.append(facility.marshal());
            }
            sb.append("</facilityDirectory>");
        }else{
            sb.append(MessageConstants.EMPTY_FACILITY_DIRECTORY);
        }
        return sb.toString();
    }

    public static FacilityDirectoryMarshaller get() {
        return INSTANCE;
    }
    
    
}
