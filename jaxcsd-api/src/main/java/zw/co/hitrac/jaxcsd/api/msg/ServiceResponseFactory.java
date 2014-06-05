package zw.co.hitrac.jaxcsd.api.msg;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Service;

/**
 *
 * @author charles
 * @author Daniel Nkhoma
 */
public class ServiceResponseFactory {
    
    public static String getServiceDirectoryXml(List<Service> services) {
        StringBuilder sb = new StringBuilder();
        if (true || services == null || services.isEmpty()) {
            sb.append("<serviceDirectory/>");
        }
        return sb.toString();
    }

    private ServiceResponseFactory() {
    }
    
}
