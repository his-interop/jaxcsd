package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceDirectoryMarshaller extends Marshaller<ServiceDirectory> {

    private static final ServiceDirectoryMarshaller INSTANCE = new ServiceDirectoryMarshaller();

    private ServiceDirectoryMarshaller() {
    }

    @Override
    public String marshal(ServiceDirectory serviceDirectory) {
        StringBuilder sb = new StringBuilder();
        if (serviceDirectory != null && serviceDirectory.getServices() != null && !serviceDirectory.getServices().isEmpty()) {
           sb.append("<serviceDirectory>");
           for(Service service:serviceDirectory.getServices()){
               sb.append(service.marshal());
           }
           sb.append("</serviceDirectory>");
        }else{
            sb.append(MessageConstants.EMPTY_SERVICE_DIRECTORY);
        }
        return sb.toString();
    }

    public static ServiceDirectoryMarshaller get() {
        return INSTANCE;
    }
}
