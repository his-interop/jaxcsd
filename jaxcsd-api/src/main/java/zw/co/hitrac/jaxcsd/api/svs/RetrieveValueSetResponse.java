package zw.co.hitrac.jaxcsd.api.svs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;

/**
 *
 * @author Charles Chigoriwa
 */
public class RetrieveValueSetResponse implements Serializable{
    
    private String version;
    private String id;
    
    private List<ValueSet> valueSets=new ArrayList<ValueSet>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ValueSet> getValueSets() {
        return valueSets;
    }

    public void setValueSets(List<ValueSet> valueSets) {
        this.valueSets = valueSets;
    }
    
    public RetrieveValueSetResponse addValueSet(ValueSet valueSet){
        this.valueSets.add(valueSet);
        return this;
    }
    
    
}
