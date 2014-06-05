package zw.co.hitrac.jaxcsd.api.query;

import java.io.Serializable;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.domain.UniqueID;

/**
 *
 * @author Charles Chigoriwa
 */
public class RequestParams implements Serializable{
    
    private UniqueID uniqueID;
    private OtherID otherID;
    private String commonName;
    private CodedType codedType;
    private Address address;
    private Integer start;
    private Integer max;
    private Record record;

    public UniqueID getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(UniqueID uniqueID) {
        this.uniqueID = uniqueID;
    }

    public OtherID getOtherID() {
        return otherID;
    }

    public void setOtherID(OtherID otherID) {
        this.otherID = otherID;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public CodedType getCodedType() {
        return codedType;
    }

    public void setCodedType(CodedType codedType) {
        this.codedType = codedType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
    
    
    
    
    
    
    
}
