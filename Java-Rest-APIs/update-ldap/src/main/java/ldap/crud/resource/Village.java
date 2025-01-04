package ldap.crud.resource;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class Village {
    String villageID;
    String villageName;
    public Village() {
    }
    public Village(Attributes attributes) throws NamingException {
        this.villageID = attributes.get("villageID").get().toString();
        this.villageName = attributes.get("villageName").get().toString();
    }
    public String getVillageID() {
        return villageID;
    }
    public void setVillageID(String villageID) {
        this.villageID = villageID;
    }
    public String getVillageName() {
        return villageName;
    }
    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}
