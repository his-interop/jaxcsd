package zw.co.hitrac.jaxcsd.api.parser.util;

import java.io.Serializable;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdElement implements Serializable {

    private String name;
    private String namespace;

    public CsdElement() {
    }

    public CsdElement(String name, String namespace) {
        this.name = name;
        this.namespace = namespace;
    }

    public CsdElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public boolean localElementEquals(XMLStreamReader r) {
        String rLocalName = r.getLocalName();
        return name.equals(rLocalName);
    }
    
    public boolean elementEquals(XMLStreamReader r){
        //TODO:: consider full equality later
        return localElementEquals(r);
    }
}
