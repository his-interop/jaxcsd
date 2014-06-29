package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityDirectoryMarshaler extends Marshaler<FacilityDirectory> {

    private static final FacilityDirectoryMarshaler INSTANCE = new FacilityDirectoryMarshaler();

    private FacilityDirectoryMarshaler() {
    }

    @Override
    public String marshal(FacilityDirectory facilityDirectory, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (facilityDirectory != null && facilityDirectory.getFacilities() != null && !facilityDirectory.getFacilities().isEmpty()) {
            sb.append("<").append(elementName).append(">");
            for (Facility facility : facilityDirectory.getFacilities()) {
                sb.append(facility.marshal());
            }
            sb.append("</").append(elementName).append(">");
        } else {
            sb.append(MessageConstants.EMPTY_FACILITY_DIRECTORY);
        }
        return sb.toString();
    }

    @Override
    public String marshal(FacilityDirectory facilityDirectory) {
        return marshal(facilityDirectory, FACILITY_DIRECTORY);
    }

    public static FacilityDirectoryMarshaler get() {
        return INSTANCE;
    }
}
