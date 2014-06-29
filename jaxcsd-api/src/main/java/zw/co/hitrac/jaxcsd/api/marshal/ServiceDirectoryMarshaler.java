package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceDirectoryMarshaler extends Marshaler<ServiceDirectory> {

    private static final ServiceDirectoryMarshaler INSTANCE = new ServiceDirectoryMarshaler();

    private ServiceDirectoryMarshaler() {
    }

    @Override
    public String marshal(ServiceDirectory serviceDirectory, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (serviceDirectory != null && serviceDirectory.getServices() != null && !serviceDirectory.getServices().isEmpty()) {
            sb.append("<").append(elementName).append(">");
            for (Service service : serviceDirectory.getServices()) {
                sb.append(service.marshal());
            }
            sb.append("</").append(elementName).append(">");
        } else {
            sb.append(MessageConstants.EMPTY_SERVICE_DIRECTORY);
        }
        return sb.toString();
    }

    @Override
    public String marshal(ServiceDirectory serviceDirectory) {
        return marshal(serviceDirectory, SERVICE_DIRECTORY);
    }

    public static ServiceDirectoryMarshaler get() {
        return INSTANCE;
    }
}
