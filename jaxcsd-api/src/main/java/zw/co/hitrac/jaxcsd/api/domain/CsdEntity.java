package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class CsdEntity extends UniqueID implements CsdMarshallable{
    
    protected List<CodedType> codedTypes=new ArrayList<CodedType>();
    protected List<Extension> extensions=new ArrayList<Extension>();
    protected Record record;

    public List<CodedType> getCodedTypes() {
        return codedTypes;
    }

    public void setCodedTypes(List<CodedType> codedTypes) {
        this.codedTypes = codedTypes;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }
    
    
    
    public CsdEntity addCodedType(String code,String codingSchema,String value){
        CodedType codedType=new CodedType(code, codingSchema, value);
        this.codedTypes.add(codedType);
        return this;
    }
    
    public CsdEntity addExtension(Extension extension){
        this.extensions.add(extension);
        return this;
    }
    
    
    
}
