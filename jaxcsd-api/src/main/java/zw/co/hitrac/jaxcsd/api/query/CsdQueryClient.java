package zw.co.hitrac.jaxcsd.api.query;

import java.io.ByteArrayInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.JaxcsdRuntimeException;
import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.parser.CsdParser;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;
import zw.co.hitrac.jaxcsd.api.util.JaxcsdResponse;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdQueryClient {

    private CsdParser csdParser = new CsdParser();

    public CSD callStandardStoredFunction(RequestParams requestParams, String functionUuid, String httpAddress, CallOptions callOptions) {
        CareServicesRequest careServicesRequest = new CareServicesRequest(new Function(functionUuid, requestParams));
        String xmlRequestBody = careServicesRequest.marshal();
        JaxcsdResponse jaxcsdResponse = JaxCsdUtil.executeXmlPost(xmlRequestBody, httpAddress);
        if (jaxcsdResponse.getStatusCode() != 200) {
            throw new JaxcsdRuntimeException(jaxcsdResponse.toString());
        }
        String xmlResponseBody = jaxcsdResponse.getBody();
        try {
            XMLInputFactory f = XMLInputFactory.newInstance();
            XMLStreamReader r = f.createXMLStreamReader(new ByteArrayInputStream(xmlResponseBody.getBytes()));
            CSD csd = new CSD();
            CsdElement csdElement = new CsdElement(CsdElementConstants.CSD);
            CsdParserExtensions csdParserExtensions = callOptions != null ? callOptions.getCsdParserExtensions() : null;
            csdParser.parse(csd, csdElement, r, csdParserExtensions);
            return csd;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new JaxcsdRuntimeException(ex);
        }
    }

    public String callNonStandardStoredFunction(RequestParams requestParams, String functionUuid, String httpAddress, CallOptions callOptions) {
        CareServicesRequest careServicesRequest = new CareServicesRequest(new Function(functionUuid, requestParams));
        String xmlRequestBody = careServicesRequest.marshal();
        JaxcsdResponse jaxcsdResponse = JaxCsdUtil.executeXmlPost(xmlRequestBody, httpAddress);
        if (jaxcsdResponse.getStatusCode() != 200) {
            throw new JaxcsdRuntimeException(jaxcsdResponse.toString());
        }
        String responseBody = jaxcsdResponse.getBody();
        return responseBody;
    }

    public void setCsdParser(CsdParser csdParser) {
        this.csdParser = csdParser;
    }
}
