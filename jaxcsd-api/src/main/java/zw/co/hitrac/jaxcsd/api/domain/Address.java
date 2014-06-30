package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.AddressLineMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.AddressMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Address implements CsdMarshalable {

    private String type;
    private List<AddressLine> addressLines = new ArrayList<AddressLine>();
    private Marshaler<Address> marshaler = AddressMarshaler.get();

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
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public static class AddressLine implements CsdMarshalable {

        private String line;
        private String component;
        private Marshaler<AddressLine> marshaler = AddressLineMarshaler.get();

        public AddressLine() {
        }

        public AddressLine(String component, String line) {
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
            return marshaler.marshal(this);
        }

        public String marshal(String elementName) {
            return marshaler.marshal(this, elementName);
        }

        public Marshaler<AddressLine> getMarshaler() {
            return marshaler;
        }

        public void setMarshaler(Marshaler<AddressLine> marshaler) {
            this.marshaler = marshaler;
        }
    }
}
