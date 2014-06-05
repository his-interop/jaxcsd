package zw.co.hitrac.jaxcsd.api.msg;

import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class ExpPushRequestFactory {

    private static String getPushRequest(String directoryBagXml) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<c:pushRequest xmlns:c=\"urn:ihe:iti:csd:2013\">");
        sb.append(directoryBagXml);
        sb.append("</c:pushRequest>");
        return sb.toString();
    }
    
    
     public static String executePushService(String directoryBagXml, String httpAddress) {
        try {           
            String xmlBody = getPushRequest(directoryBagXml);
         return JaxCsdUtil.executeXmlPost(xmlBody, httpAddress);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
     

}
