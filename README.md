#Jaxcsd

Jaxcsd stands for Java API for Xml Care Service Directory. It is an open source project developed to facilitate making Care Service Directories adhere to the Care Service Discovery Standard. The project also facilitates Care Service Finders to query data from the Info Manager. In JAXCSD, the operation invocation is represented by an XML-based CSD Standard. The CSD Standard defines a CSD schema which has the envelope structure, encoding rules, and conventions for representing the operation invocations and responses. These calls and responses are transmitted via the API over HTTP.The JAXCSD API hides the complexity of the operations that are involved from the application developer.


JAXCSD was developed to address the Zimbabwean Health Integation use case of implementing the CSD Standard, however it can be reused to suit other possible implementations. This is the alpha version of the project and is work in progress.



##Setting Up

Jaxcsd was developed as a java project that is maven built. It can be opened using Netbeans IDE or Eclipse IDE or any IDE that supports Maven projects. Clone the project and open it using the IDE of your choice.

###Examples
####Care Services Request Invocation
```java
RequestParams requestParams = new RequestParams();
requestParams.setCommonName("Charles Chigoriwa");
requestParams.setStart(1);
requestParams.setMax(5000);
List<Provider> providers = StoredQueryManager.getProviders(requestParams, "http://192.168.1.23:8984/CSD/csr/mohcc/careServicesRequest");
  //use returned providers for your  convenience
```
####Preparing and marshaling care service directory 
```java
CSD csd=new CSD();
Provider provider = new Provider();
provider.setOid("1.3.6.1.4.1.21367.200.99.1111");
provider.addCodedType("105-007", "1.3.6.1.4.1.21367.100.1", "Physician/Medical Oncology");
//Demographic
Person demographic = new Person();
demographic.addName(new Name("Dr.", "Banerjee", "Dev").addCommonName("Banargee, Dev"));
demographic.addContactPoint(new ContactPoint(new CodedType("BP", "urn:ihe:iti:csd:2013:contactPoint", "555-777-1111")));
demographic.addContactPoint(new ContactPoint(new CodedType("FAX", "urn:ihe:iti:csd:2013:contactPoint", "555-888-1111")));
demographic.addAddress(new Address("Mailing")
                .addAddressLine("streetAddress", "8909 Sunset Way")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87505"));
demographic.setGender("M");
provider.setDemographic(demographic);

provider.addLanguage("en", "BCP 47", "English")
        .addLanguage("bn", "BCP 47", "Bengali");

provider.addProviderOrganization(new ProviderOrganization("1.3.6.1.4.1.21367.200.99.1"))
        .addProviderOrganization(new ProviderOrganization("1.3.6.1.4.1.21367.200.99.3"));

provider.addCredential(new Credential(new CodedType("109-003", "1.3.6.1.4.1.21367.100.1"), "108-001", "Connectathon_Manager", JaxCsdUtil.toDateFromIsoShortString("2013-12-01"), null));

provider.addSpecialty("109-003", "1.3.6.1.4.1.21367.100.1", "");

provider.setRecord(new Record(new Date(), new Date(), "Active"));

csd.addProvider(provider);
String csdXmlString = csd.marshal();
//do what ever you want with this csdXmlString
//You can send it to a file or give it  to Mr OpenInfoMan upon request
//In the mean time let us send it to the conventional console
System.out.print(csdXmlString);


```



##To do

As highlighted this is an alpha version of the project and a lot of work needs to be done.

* There is need to implement unit testing, functional testing and incorporate JUnit in the project.
* Incorporate javadoc for the project. 