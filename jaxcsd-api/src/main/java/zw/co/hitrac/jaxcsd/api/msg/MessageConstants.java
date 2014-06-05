package zw.co.hitrac.jaxcsd.api.msg;

/**
 *
 * @author Charles Chigoriwa
 */
public class MessageConstants {
    
    public static final String XML_PROLOG="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public static final String SOAP_NS="http://www.w3.org/2003/05/soap-envelope";
    public static final String WSA_NS="http://www.w3.org/2005/08/addressing";
    public static final String CSD_NS="urn:ihe:iti:csd:2013";
    
    public static final String EMPTY_PROVIDER_DIRECTORY="<providerDirectory />";
    public static final String EMPTY_SERVICE_DIRECTORY="<serviceDirectory />";
    public static final String EMPTY_ORGANIZATION_DIRECTORY="<organizationDirectory />";
    public static final String EMPTY_FACILITY_DIRECTORY="<facilityDirectory />";
    

    private MessageConstants() {
    }
    
    
    
}
