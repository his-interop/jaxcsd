package zw.co.hitrac.jaxcsd.api.svs;

import java.io.ByteArrayInputStream;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.parser.RetrieveValueSetResponseParser;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class SvsManager {

    private static final RetrieveValueSetResponseParser retrieveValueSetResponseParser = new RetrieveValueSetResponseParser();

    public static List<ValueSet> retrieveValueSet(String id, String hostAddress) {
        String httpAddress = hostAddress + "/CSD/SVS/RetrieveValueSet?ID=" + id;
        String xmlResponseBody = JaxCsdUtil.executeGet(httpAddress);
        //System.out.println(xmlResponseBody);
        try {
            RetrieveValueSetResponse retrieveValueSetResponse = new RetrieveValueSetResponse();
            XMLInputFactory f = XMLInputFactory.newInstance();
            XMLStreamReader r = f.createXMLStreamReader(new ByteArrayInputStream(xmlResponseBody.getBytes()));

            retrieveValueSetResponseParser.parse(retrieveValueSetResponse, new CsdElement(CsdElementConstants.RETRIEVE_VALUE_SET_RESPONSE), r, null);

            return retrieveValueSetResponse.getValueSets();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);

        }
        
        return null;
    }

    

    public static void main(String[] args) {
        List<ValueSet> valueSets = retrieveValueSet("2.25.278833312560998189344547095792153373333", "http://localhost:8984");
        for (ValueSet valueSet : valueSets) {
            for (ConceptList conceptList : valueSet.getConceptLists()) {
                for (Concept concept : conceptList.getConcepts()) {
                    System.out.println(" code: " + concept.getCode() + " displayName: " + concept.getDisplayName() + " codeSystem: " + concept.getCodeSystem());
                }
            }
        }
    }
}
