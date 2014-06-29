package zw.co.hitrac.jaxcsd.api.query;

import java.io.ByteArrayInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.parser.CsdParser;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdQueryClient {

    private CsdParser csdParser = new CsdParser();

    public CSD callStandardStoredFunction(RequestParams requestParams, String functionUuid, String httpAddress, CallOptions callOptions) {
        CareServicesRequest careServicesRequest = new CareServicesRequest(new Function(functionUuid, requestParams));
        String xmlRequestBody = careServicesRequest.marshal();
        String xmlResponseBody = JaxCsdUtil.executeXmlPost(xmlRequestBody, httpAddress);
        try {
            XMLInputFactory f = XMLInputFactory.newInstance();
            XMLStreamReader r = f.createXMLStreamReader(new ByteArrayInputStream(xmlResponseBody.getBytes()));
            CSD csd = new CSD();
            CsdParserExtensions csdParserExtensions = callOptions != null ? callOptions.getCsdParserExtensions() : null;
            csdParser.parse(csd, r, csdParserExtensions);
            return csd;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException(ex);
        }
    }
    
    public String callNonStandardStoredFunction(RequestParams requestParams, String functionUuid, String httpAddress, CallOptions callOptions) {
        CareServicesRequest careServicesRequest = new CareServicesRequest(new Function(functionUuid, requestParams));
        String xmlRequestBody = careServicesRequest.marshal();
        String responseBody = JaxCsdUtil.executeXmlPost(xmlRequestBody, httpAddress);
        return responseBody;
    }
    
    

    public void setCsdParser(CsdParser csdParser) {
        this.csdParser = csdParser;
    }
    
   }
