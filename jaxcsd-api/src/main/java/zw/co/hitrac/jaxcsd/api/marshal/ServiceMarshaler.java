package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Date;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceMarshaler extends Marshaler<Service> {

    private static final ServiceMarshaler INSTANCE = new ServiceMarshaler();

    private ServiceMarshaler() {
    }

    @Override
    public String marshal(Service service, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(" oid=\"").append(service.getOid()).append("\">");
        sb.append(CodedTypeListMarshaler.get().marshal(service.getCodedTypes(), "codedType"));
        sb.append(ExtensionListMarshaller.get().marshal(service.getExtensions()));
        sb.append(RecordMarshaler.get().marshal(service.getRecord()));
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(Service service) {
        return marshal(service, SERVICE);
    }

    public static ServiceMarshaler get() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Service service = new Service();
        service.setOid("1.3.6.1.4.1.21367.200.99.111.101.101");
        service.addCodedType("101-001", "1.3.6.1.4.1.21367.100.1", "");
        service.setRecord(new Record(new Date(), new Date(), "Active"));
        System.out.println(service.marshal());
    }
}
