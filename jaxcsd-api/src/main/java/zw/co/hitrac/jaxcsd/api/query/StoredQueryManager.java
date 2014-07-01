package zw.co.hitrac.jaxcsd.api.query;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class StoredQueryManager {
    
    public static List<Provider> getProviders(RequestParams requestParams, String httpAddress) {
        CareServicesRequest careServicesRequest = new CareServicesRequest(new Function(StoredQueryConstants.PROVIDER_SEARCH, requestParams));
        String xmlRequestBody = careServicesRequest.marshal();
        System.out.println("xmlBody=" + xmlRequestBody);
        String xmlResponseBody = JaxCsdUtil.executeXmlPost(xmlRequestBody, httpAddress);
        //System.out.print("response=" + xmlResponseBody);
        try {
            /*CSD csd = CSDHandler.getCSD(xmlResponseBody);
            if(csd!=null && csd.getProviderDirectory()!=null){
                return csd.getProviderDirectory().getProviders();
            }*/
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException(ex);
        }
        
        return null;
        
    }
    
      public static List<Facility> getFacilities(RequestParams requestParams, String httpAddress) {
        CareServicesRequest careServicesRequest = new CareServicesRequest(new Function(StoredQueryConstants.FACILITY_SEARCH, requestParams));
        String xmlRequestBody = careServicesRequest.marshal();
        System.out.println("xmlBody=" + xmlRequestBody);
        String xmlResponseBody = JaxCsdUtil.executeXmlPost(xmlRequestBody, httpAddress);
        //System.out.print("response=" + xmlResponseBody);
        try {
            /*CSD csd = CSDHandler.getCSD(xmlResponseBody);
            if(csd!=null && csd.getProviderDirectory()!=null){
                return csd.getFacilityDirectory().getFacilities();
            }*/
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
        return null;
        
    }
      
      public static String pushCSD(RequestParams requestParams, String httpAddress) {
        CareServicesRequest careServicesRequest = new CareServicesRequest(new Function(StoredQueryConstants.PUSH_REQUEST, requestParams));
        String xmlRequestBody = careServicesRequest.marshal();
        System.out.println("xmlBody=" + xmlRequestBody);
        String xmlResponseBody = JaxCsdUtil.executeXmlPost(xmlRequestBody, httpAddress);
        return xmlResponseBody;
        
    }
      
     
      
    
    
    
    
    
    public static void main(String[] args) {
        RequestParams requestParams = new RequestParams();
        //requestParams.setUniqueID(new Provider("2.25.231042483471474750523306613509563984609"));
        //equestParams.setCommonName("chigo");
        //requestParams.setStart(20000);
        requestParams.setOtherID(new OtherID("08-563960B29", "mohaffairs.org.zw"));
        requestParams.setMax(5);
        List<Provider> providers=getProviders(requestParams, "http://192.168.1.23:8984/CSD/csr/ncz/careServicesRequest");
        if(providers!=null && !providers.isEmpty()){
            for(Provider provider: providers){
                System.out.println("Surname :"+provider.getTopName().getSurname());
            }
        }
    }
}
