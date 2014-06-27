package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.PushRequest;

/**
 *
 * @author Charles Chigoriwa
 */
public class PushRequestMarshaller extends Marshaller<PushRequest>{
    
   private static final PushRequestMarshaller INSTANCE=new PushRequestMarshaller();

    @Override
    public String marshal(PushRequest pushRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("<pushRequest>");
        sb.append(pushRequest.getCsd().marshal());
        sb.append("</pushRequest>");
        return sb.toString();
    }

    public static PushRequestMarshaller get() {
        return INSTANCE;
    }
    
    
    
}
