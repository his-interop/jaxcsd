package zw.co.hitrac.jaxcsd.api.marshal;

import junit.framework.TestCase;
import zw.co.hitrac.jaxcsd.api.domain.Address;

/**
 *
 * @author charles
 */
public class AddressLineMarshalerTest extends TestCase {
    
    public AddressLineMarshalerTest(String testName) {
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
     * Test of marshal method, of class AddressLineMarshaler.
     */
    public void testMarshal_AddressAddressLine_String() {
        System.out.println("marshal");
        Address.AddressLine addressLine = new Address.AddressLine("comp", "line");
        String elementName = "addressLine";
        AddressLineMarshaler instance = new AddressLineMarshaler();
        String expResult = "<addressLine component=\"comp\">line</addressLine>";
        String result = instance.marshal(addressLine, elementName);
        assertEquals(expResult, result);
    }

    /**
     * Test of marshal method, of class AddressLineMarshaler.
     */
    public void testMarshal_AddressAddressLine() {
        System.out.println("marshal");
        Address.AddressLine addressLine = new Address.AddressLine("comp", "line");
        AddressLineMarshaler instance = new AddressLineMarshaler();
        String expResult = "<addressLine component=\"comp\">line</addressLine>";
        String result = instance.marshal(addressLine);
        assertEquals(expResult, result);
    }

    
}
