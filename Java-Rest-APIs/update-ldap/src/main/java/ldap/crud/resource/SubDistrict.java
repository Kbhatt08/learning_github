package ldap.crud.resource;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class SubDistrict {
    String subDistrictID;
    String subDistrictName;
    public SubDistrict() {
    }
    public SubDistrict(Attributes attributes) throws NamingException {
        this.subDistrictID = attributes.get("subDistrictID").get().toString();
        this.subDistrictName = attributes.get("subDistrictName").get().toString();
    }
    public String getSubDistrictID() {
        return subDistrictID;
    }
    public void setSubDistrictID(String subDistrictID) {
        this.subDistrictID = subDistrictID;
    }
    public String getSubDistrictName() {
        return subDistrictName;
    }
    public void setSubDistrictName(String subDistrictName) {
        this.subDistrictName = subDistrictName;
    }
}
