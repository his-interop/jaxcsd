package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public class CodedType implements Serializable{
    
    private String code;
    private String codingSchema;
    private String value="";

    public CodedType() {
    }

    public CodedType(String code, String codingSchema) {
        this(code, codingSchema, "");
    }
    
    
    
    

    public CodedType(String code, String codingSchema, String value) {
        this.code = code;
        this.codingSchema = codingSchema;
        this.value = value;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodingSchema() {
        return codingSchema;
    }

    public void setCodingSchema(String codingSchema) {
        this.codingSchema = codingSchema;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String name) {
        this.value = name;
    }

       
    
    
}
