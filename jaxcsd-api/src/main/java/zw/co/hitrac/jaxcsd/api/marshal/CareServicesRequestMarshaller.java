package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.query.CareServicesRequest;

/**
 *
 * @author Charles Chigoriwa
 */
public class CareServicesRequestMarshaller extends Marshaller<CareServicesRequest>{
    
    private static final CareServicesRequestMarshaller INSTANCE=new CareServicesRequestMarshaller();

    private CareServicesRequestMarshaller() {
    }

    
    
    
    @Override
    public String marshal(CareServicesRequest careServicesRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("<csd:careServicesRequest xmlns:csd='urn:ihe:iti:csd:2013' xmlns='urn:ihe:iti:csd:2013'>");
        if(careServicesRequest.getFunction()!=null){
            sb.append(FunctionMarshaller.get().marshal(careServicesRequest.getFunction()));
        }else if(careServicesRequest.getExpression()!=null){
            //TODO: work on adhoc expression marshaller later (since it's optional)
        }
        sb.append("</csd:careServicesRequest>");
        return sb.toString();
    }

    public static CareServicesRequestMarshaller get() {
        return INSTANCE;
    }
    
    
    
}
