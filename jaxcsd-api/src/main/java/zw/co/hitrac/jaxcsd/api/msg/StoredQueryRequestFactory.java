package zw.co.hitrac.jaxcsd.api.msg;

import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class StoredQueryRequestFactory {

    private static String getStoredQueryRequest(String params, String functionUuid) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<csd:careServicesRequest xmlns:csd='urn:ihe:iti:csd:2013' xmlns='urn:ihe:iti:csd:2013'>");
        sb.append("<function uuid=\"").append(functionUuid).append("\">");
        sb.append("<requestParams>");
        sb.append(params);
        sb.append("</requestParams>");
        sb.append("</function>");
        sb.append("</csd:careServicesRequest>");
        return sb.toString();

    }

    public static String executeStoredQuery(String params, String functionUuid, String httpAddress) {
        String xmlBody = getStoredQueryRequest(params, functionUuid);
        return JaxCsdUtil.executeXmlPost(xmlBody, httpAddress);
    }

    public static void main(String[] args) {
        /**
         * Parameters
         */
        StringBuilder sb = new StringBuilder();
        //sb.append(InlineXmlElementFactory.getInlineXmlElement("codedType",new AttributesWrapper("code","-1621032776").add("codingScheme", "1.3.6.1.4.1.21367.100.1")));
        String params = sb.toString();
        /*End of parameters*/


        String functionUuid = "4e8bbeb9-f5f5-11e2-b778-0800200c9a66";
        String httpAddress = "http://localhost:8984/CSD/csr/mohcc/careServicesRequest";
        String responseXmlBody = executeStoredQuery(params, functionUuid, httpAddress);
        System.out.println(responseXmlBody);
        try {
            /*CSD csd=CSDHandler.getCSD(responseXmlBody);
            
            if(csd.getProviderDirectory()!=null && csd.getProviderDirectory().getProviders()!=null){
                for(Provider provider:csd.getProviderDirectory().getProviders()){
                    System.out.println("======"+provider.getDemographic().getNames().get(0).getSurname());
                }
            }*/
        } catch (Exception ex) {
        }
    }

    private StoredQueryRequestFactory() {
    }
}
