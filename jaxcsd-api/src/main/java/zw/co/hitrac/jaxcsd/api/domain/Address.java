package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.AddressLineMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.AddressMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Address implements CsdMarshalable {

    private String type;
    private List<AddressLine> addressLines = new ArrayList<AddressLine>();

    public Address() {
    }

    public Address(String type) {
        this.type = type;
    }
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AddressLine> getAddressLines() {
        return addressLines;
    }

    public void setAddressLines(List<AddressLine> addressLines) {
        this.addressLines = addressLines;
    }

    public Address addAddressLine(String line, String component) {
        this.addressLines.add(new AddressLine(line, component));
        return this;
    }

    public String marshal() {
       return AddressMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return AddressMarshaler.get().marshal(this,elementName);
    }

    public static class AddressLine implements CsdMarshalable {

        private String line;
        private String component;

        public AddressLine() {
        }

        public AddressLine(String component,String line) {
            this.line = line;
            this.component = component;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public String marshal() {
            return AddressLineMarshaler.get().marshal(this);
        }

        public String marshal(String elementName) {
            return AddressLineMarshaler.get().marshal(this,elementName);
        }
        
        
    }
}
