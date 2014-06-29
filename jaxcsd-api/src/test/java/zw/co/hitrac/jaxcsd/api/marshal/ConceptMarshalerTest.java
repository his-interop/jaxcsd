package zw.co.hitrac.jaxcsd.api.marshal;

import junit.framework.TestCase;
import zw.co.hitrac.jaxcsd.api.domain.Concept;

/**
 *
 * @author Charles Chigoriwa
 * 
 */
public class ConceptMarshalerTest extends TestCase {
    
    public ConceptMarshalerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of marshal method, of class ConceptMarshaler.
     */
    public void testMarshal() {
        System.out.println("marshal");
        Concept concept = new Concept("myCode", "myDisplayName", "myCodeSystem");
        ConceptMarshaler instance = new ConceptMarshaler();
        String expResult = "<Concept code=\"myCode\" displayName=\"myDisplayName\" codeSystem=\"myCodeSystem\"></Concept>";
        String result = instance.marshal(concept);
        assertEquals(expResult, result);
    }

    
}
