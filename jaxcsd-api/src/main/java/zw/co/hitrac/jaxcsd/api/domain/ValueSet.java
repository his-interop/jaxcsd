package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ValueSetMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ValueSet implements CsdMarshalable{
    
    private String id;
    private String displayName;
    private String version;
    
    private List<ConceptList> conceptLists=new ArrayList<ConceptList>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ConceptList> getConceptLists() {
        return conceptLists;
    }

    public void setConceptLists(List<ConceptList> conceptLists) {
        this.conceptLists = conceptLists;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public ValueSet addConceptList(ConceptList conceptList){
        this.conceptLists.add(conceptList);
        return this;
    }

    public String marshal() {
        return ValueSetMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return ValueSetMarshaler.get().marshal(this, elementName);
    }
    
}
