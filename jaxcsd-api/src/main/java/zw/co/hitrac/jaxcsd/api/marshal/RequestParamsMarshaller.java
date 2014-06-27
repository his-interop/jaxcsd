package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
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
           
           if(requestParams.getCodedType()!=null){
               Map<String,String> attributes=new LinkedHashMap<String, String>();
               attributes.put("code", requestParams.getCodedType().getCode());
               attributes.put("codingSchema", requestParams.getCodedType().getCodingSchema());
               sb.append(getInlineXmlElement("codedType", attributes));
           }
           
           if(requestParams.getOtherID()!=null){
               Map<String,String> attributes=new LinkedHashMap<String, String>();
               attributes.put("code", requestParams.getOtherID().getCode());
               attributes.put("assigningAuthorityName", requestParams.getOtherID().getAssigningAuthorityName());
               sb.append(getInlineXmlElement("otherID", attributes));
           }
           
           if(requestParams.getStart()!=null){
              sb.append(getInlineXmlElement("start", String.valueOf(requestParams.getStart()))); 
           }
           
           if(requestParams.getMax()!=null){
               sb.append(getInlineXmlElement("max", String.valueOf(requestParams.getMax()))); 
           }
           
           if(requestParams.getPushRequest()!=null){
               sb.append(requestParams.getPushRequest().marshal());
           }
       }
       sb.append("</requestParams>");
       return sb.toString();
    }

    public static RequestParamsMarshaller get() {
        return INSTANCE;
    }
}
