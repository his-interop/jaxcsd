package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public class Person implements Serializable{
    
    private List<Name> names=new ArrayList<Name>();
    private String gender;
    private List<ContactPoint> contactPoints=new ArrayList<ContactPoint>();
    private Date dateOfBirth;
    private List<Address> addresses=new ArrayList<Address>();

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<ContactPoint> getContactPoints() {
        return contactPoints;
    }

    public void setContactPoints(List<ContactPoint> contactPoints) {
        this.contactPoints = contactPoints;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    public Person addAddress(Address address){
        this.addresses.add(address);
        return this;
    }
    
    public Person addContactPoint(ContactPoint contactPoint){
        this.contactPoints.add(contactPoint);
        return this;
    }
    
    public Person addName(Name name){
        this.names.add(name);
        return this;
    }
}
