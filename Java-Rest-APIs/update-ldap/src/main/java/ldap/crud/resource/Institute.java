package ldap.crud.resource;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class Institute {
    String instituteID;
    String instituteName;
    String isSchool;
    String isCollege;
    String districtName;
    String stateName;
    String instituteCode;
    public Institute() {
    }
    public Institute(Attributes attributes) throws NamingException {
        
        this.instituteID = attributes.get("instituteid").get().toString();
        this.instituteName = attributes.get("cn").get().toString();
        this.isSchool =attributes.get("isschool").get().toString();
        this.isCollege=attributes.get("iscollege").get().toString();
        this.isCollege=attributes.get("iscollege").get().toString();
        this.districtName=attributes.get("districtName").get().toString();
        this.stateName=attributes.get("stateName").get().toString();
        this.instituteCode=attributes.get("institutecode").get().toString();
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getInstituteID() {
        return instituteID;
    }
    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }
    public String getInstituteName() {
        return instituteName;
    }
    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
    public String getIsSchool() {
        return isSchool;
    }
    public void setIsSchool(String isSchool) {
        this.isSchool = isSchool;
    }
    public String getIsCollege() {
        return isCollege;
    }
    public void setIsCollege(String isCollege) {
        this.isCollege = isCollege;
    }
    public String getInstituteCode() {
        return instituteCode;
    }
    public void setInstituteCode(String instituteCode) {
        this.instituteCode = instituteCode;
    }
}
