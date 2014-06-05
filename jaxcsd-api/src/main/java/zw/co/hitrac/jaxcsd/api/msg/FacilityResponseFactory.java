package zw.co.hitrac.jaxcsd.api.msg;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Facility;

/**
 *
 * @author charles
 * @author daniel nkhoma
 */
public class FacilityResponseFactory {
    
    public static String getFacilityDirectoryXml(List<Facility> facilities) {
        StringBuilder sb = new StringBuilder();
        if (true || facilities == null || facilities.isEmpty()) {
            sb.append("<facilityDirectory/>");
        }
        return sb.toString();
    }

    private FacilityResponseFactory() {
    }
    
}
