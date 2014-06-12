package zw.co.hitrac.jaxcsd.api.svs;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Concept;
import zw.co.hitrac.jaxcsd.api.domain.ConceptList;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;
import zw.co.hitrac.jaxcsd.api.xp.RetrieveValueSetResponseHandler;

/**
 *
 * @author Charles Chigoriwa
 */
public class SvsManager {

    public static List<ValueSet> retrieveValueSet(String id, String hostAddress) {
        String httpAddress = hostAddress + "/CSD/SVS/RetrieveValueSet?ID=" + id;
        String xmlResponseBody = JaxCsdUtil.executeGet(httpAddress);
        System.out.println(xmlResponseBody);
        try {
            RetrieveValueSetResponse retrieveValueSetResponse = RetrieveValueSetResponseHandler.getRetrieveValueSetResponse(xmlResponseBody);
            if (retrieveValueSetResponse != null) {
                return retrieveValueSetResponse.getValueSets();
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException(ex);
        }

        return null;
    }
    
    public static void main(String[] args){
        List<ValueSet> valueSets=retrieveValueSet("2.25.278833312560998189344547095792153373333", "http://localhost:8984");
        for(ValueSet valueSet:valueSets){
            for(ConceptList conceptList:valueSet.getConceptLists()){
                for(Concept concept:conceptList.getConcepts()){
                    System.out.println(" code: "+concept.getCode()+" displayName: "+concept.getDisplayName()+" codeSystem: "+concept.getCodeSystem());
                }
            }
        }
    }
    
    
}
