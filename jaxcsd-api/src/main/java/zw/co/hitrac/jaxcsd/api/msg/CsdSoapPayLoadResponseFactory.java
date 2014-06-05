package zw.co.hitrac.jaxcsd.api.msg;

import zw.co.hitrac.jaxcsd.api.domain.DirectoryBag;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdSoapPayLoadResponseFactory {  
        
    public static String getCsdSoapPayloadXml(DirectoryBag directoryBag){
        StringBuilder sb=new StringBuilder();
        sb.append("<csd:getModificationsResponse>");
        sb.append(DirectoryBagResponseFactory.getCsdBagXml(directoryBag));
        sb.append("</csd:getModificationsResponse>");
        return sb.toString();
    }

    private CsdSoapPayLoadResponseFactory() {
    }
    
    
    
    
    
    
}
