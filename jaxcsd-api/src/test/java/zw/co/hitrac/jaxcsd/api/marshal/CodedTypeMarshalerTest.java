package zw.co.hitrac.jaxcsd.api.marshal;

import junit.framework.TestCase;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;

/**
 *
 * @author Charles Chigoriwa
 */
public class CodedTypeMarshalerTest extends TestCase {
    
    public CodedTypeMarshalerTest(String testName) {
        super(testName);
    }

    /**
     * Test of marshal method, of class CodedTypeMarshaler.
     */
    public void testMarshalCodedTypeString() {
        System.out.println("marshal");
        CodedType codedType = new CodedType("myCode", "myCodingSchema");
        String elementName = "language";
        CodedTypeMarshaler instance = new CodedTypeMarshaler();
        String expResult = "<language code=\"myCode\" codingSchema=\"myCodingSchema\"></language>";
        String result = instance.marshal(codedType, elementName);
        assertEquals(expResult, result);
    }

    /**
     * Test of marshal method, of class CodedTypeMarshaler.
     */
    public void testMarshalCodedType() {
        System.out.println("marshal");
        CodedType codedType =new CodedType("0400", "12.1.2.9.56", "Student Nurse");
        CodedTypeMarshaler instance = new CodedTypeMarshaler();
        String expResult = "<codedType code=\"0400\" codingSchema=\"12.1.2.9.56\">Student Nurse</codedType>";
        String result = instance.marshal(codedType);
        assertEquals(expResult, result);
    }

   
}
