package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ConceptListMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ConceptList implements CsdMarshalable {

    private String lang;
    private List<Concept> concepts = new ArrayList<Concept>();
    private Marshaler<ConceptList> marshaler = ConceptListMarshaler.get();

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

    public ConceptList addConcept(Concept concept) {
        this.concepts.add(concept);
        return this;
    }

    public ConceptList addConcept(String code, String displayName, String codeSystem) {
        return this.addConcept(new Concept(code, displayName, codeSystem));
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<ConceptList> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<ConceptList> marshaler) {
        this.marshaler = marshaler;
    }
}
