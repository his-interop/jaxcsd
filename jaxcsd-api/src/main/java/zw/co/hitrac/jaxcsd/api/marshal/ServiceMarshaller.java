package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Date;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.marshal.ext.ExtensionListMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceMarshaller extends Marshaller<Service> {

    private static final ServiceMarshaller INSTANCE = new ServiceMarshaller();

    private ServiceMarshaller() {
    }

    @Override
    public String marshal(Service service) {
        StringBuilder sb = new StringBuilder();
        sb.append("<service oid=\"").append(service.getOid()).append("\">");
        sb.append(CodedTypeListMarshaller.get().marshal(service.getCodedTypes(),"codedType"));
        sb.append(ExtensionListMarshaller.get().marshal(service.getExtensions()));
        sb.append(RecordMarshaller.get().marshal(service.getRecord()));
        sb.append("</service>");
        return sb.toString();
    }

    public static ServiceMarshaller get() {
        return INSTANCE;
    }
    
    public static void main(String[] args){
        Service service=new Service();
        service.setOid("1.3.6.1.4.1.21367.200.99.111.101.101");
        service.addCodedType("101-001", "1.3.6.1.4.1.21367.100.1", "");
        service.setRecord(new Record(new Date(), new Date(), "Active"));
        System.out.println(service.marshal());
    }
}
