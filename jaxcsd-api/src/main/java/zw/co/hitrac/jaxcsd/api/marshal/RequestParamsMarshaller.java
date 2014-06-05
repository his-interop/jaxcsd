package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import zw.co.hitrac.jaxcsd.api.query.RequestParams;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class RequestParamsMarshaller extends Marshaller<RequestParams>{
    
    
    private static final RequestParamsMarshaller INSTANCE=new RequestParamsMarshaller();

    private RequestParamsMarshaller() {
    }
    
    

    @Override
    public String marshal(RequestParams requestParams) {
       StringBuilder sb=new StringBuilder();
       sb.append("<requestParams>");
       if(requestParams!=null){
           if(requestParams.getUniqueID()!=null && requestParams.getUniqueID().getOid()!=null){
              sb.append(getInlineXmlElement("id", new AttributesWrapper("oid", requestParams.getUniqueID().getOid())));
           }
           
           if(requestParams.getCommonName()!=null){
               sb.append(getInlineXmlElement("commonName", requestParams.getCommonName()));
           }
           
           if(requestParams.getStart()!=null){
              sb.append(getInlineXmlElement("start", String.valueOf(requestParams.getStart()))); 
           }
           
           if(requestParams.getMax()!=null){
               sb.append(getInlineXmlElement("max", String.valueOf(requestParams.getMax()))); 
           }
       }
       sb.append("</requestParams>");
       return sb.toString();
    }

    public static RequestParamsMarshaller get() {
        return INSTANCE;
    }
}
