package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.CodedTypeMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class CodedType implements CsdMarshalable {

    private String code;
    private String codingScheme;
    private String value = "";
    private Marshaler<CodedType> marshaler = CodedTypeMarshaler.get();

    public CodedType() {
    }

    public CodedType(String code, String codingScheme) {
        this(code, codingScheme, "");
    }

    public CodedType(String code, String codingScheme, String value) {
        this.code = code;
        this.codingScheme = codingScheme;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodingScheme() {
        return codingScheme;
    }

    public void setCodingScheme(String codingScheme) {
        this.codingScheme = codingScheme;
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
