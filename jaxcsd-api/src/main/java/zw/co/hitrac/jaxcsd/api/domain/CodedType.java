package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.CodedTypeMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class CodedType implements CsdMarshalable {

    private String code;
    private String codingSchema;
    private String value = "";
    private Marshaler<CodedType> marshaler = CodedTypeMarshaler.get();

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

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<CodedType> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<CodedType> marshaler) {
        this.marshaler = marshaler;
    }
}
