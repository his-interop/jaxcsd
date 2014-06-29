package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.ConceptMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Concept implements CsdMarshalable{
    
   
    
    private String code;
    private String displayName;
    private String codeSystem;

    public Concept() {
    }

    public Concept(String code, String displayName, String codeSystem) {
        this.code = code;
        this.displayName = displayName;
        this.codeSystem = codeSystem;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCodeSystem() {
        return codeSystem;
    }

    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    public String marshal() {
        return ConceptMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return ConceptMarshaler.get().marshal(this,elementName);
    }
    
    
}
