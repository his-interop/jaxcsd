package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ConceptListMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ConceptList implements CsdMarshalable{
    
    private String lang;
    
    private List<Concept> concepts=new ArrayList<Concept>();

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }
    
    public ConceptList addConcept(Concept concept){
        this.concepts.add(concept);
        return this;
    }
    
    public ConceptList addConcept(String code,String displayName,String codeSystem){
        return this.addConcept(new Concept(code, displayName, codeSystem));
    }

    public String marshal() {
      return ConceptListMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
      return ConceptListMarshaler.get().marshal(this,elementName);
    }
    
    
    
}
