package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class CSDMarshaller extends Marshaller<CSD> {

    private static final CSDMarshaller INSTANCE = new CSDMarshaller();

    private CSDMarshaller() {
    }

    @Override
    public String marshal(CSD csd) {
        StringBuilder sb = new StringBuilder();
        sb.append("<CSD xmlns=\"urn:ihe:iti:csd:2013\">");
        
        if (csd.getOrganizationDirectory() != null) {
            sb.append(csd.getOrganizationDirectory().marshal());
        }else{
            sb.append(MessageConstants.EMPTY_ORGANIZATION_DIRECTORY);
        }
        
        if(csd.getServiceDirectory()!=null){
            sb.append(csd.getServiceDirectory().marshal());
        }else{
            sb.append(MessageConstants.EMPTY_SERVICE_DIRECTORY);
        }
        
        if(csd.getFacilityDirectory()!=null){
            sb.append(csd.getFacilityDirectory().marshal());
        }else{
            sb.append(MessageConstants.EMPTY_FACILITY_DIRECTORY);
        }
        
        if(csd.getProviderDirectory()!=null){
            sb.append(csd.getProviderDirectory().marshal());
        }else{
            sb.append(MessageConstants.EMPTY_PROVIDER_DIRECTORY);
        }
        
        sb.append("</CSD>");
        return sb.toString();
    }

    public static CSDMarshaller get() {
        return INSTANCE;
    }
}
