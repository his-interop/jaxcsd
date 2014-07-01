package zw.co.hitrac.jaxcsd.api.marshal;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import zw.co.hitrac.jaxcsd.api.domain.Address;

/**
 *
 * @author charles
 */
public class AddressMarshalerTest extends TestCase {
    
    public AddressMarshalerTest(String testName) {
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
     * Test of marshal method, of class AddressMarshaler.
     */
    public void testMarshal_Address() {
        System.out.println("marshal");
        Address address = new Address("Mailing")
                .addAddressLine("streetAddress", "8909 Sunset Way")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87505");
        //String elementName = "";
        AddressMarshaler instance = new AddressMarshaler();
        String expResult = "<address type=\"Mailing\"><addressLine component=\"streetAddress\">8909 Sunset Way</addressLine><addressLine component=\"city\">Santa Fe</addressLine><addressLine component=\"stateProvince\">NM</addressLine><addressLine component=\"country\">USA</addressLine><addressLine component=\"postalCode\">87505</addressLine></address>";
        //String result = instance.marshal(address, elementName);
        String result = instance.marshal(address);
        assertEquals(expResult, result);
    }
    
    public void testMarshal_Address_String() {
        System.out.println("marshal");
        Address address = new Address("Mailing")
                .addAddressLine("streetAddress", "8909 Sunset Way")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87505");
        String elementName = "myAddress";
        AddressMarshaler instance = new AddressMarshaler();
        String expResult = "<myAddress type=\"Mailing\"><addressLine component=\"streetAddress\">8909 Sunset Way</addressLine><addressLine component=\"city\">Santa Fe</addressLine><addressLine component=\"stateProvince\">NM</addressLine><addressLine component=\"country\">USA</addressLine><addressLine component=\"postalCode\">87505</addressLine></myAddress>";
        String result = instance.marshal(address, elementName);
        assertEquals(expResult, result);
    }

  

   
}
