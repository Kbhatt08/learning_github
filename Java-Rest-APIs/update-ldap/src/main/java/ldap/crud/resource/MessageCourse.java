package ldap.crud.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageCourse {
    private String status;
    private Map<String,?> exceptions=new HashMap<>();
    private List<?> list=new ArrayList<>();
    public MessageCourse(String status, Map<String, ?> exceptions, List<?> list) {
        this.status = status;
        this.exceptions = exceptions;
        this.list = list;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Map<String, ?> getExceptions() {
        return exceptions;
    }
    public void setExceptions(Map<String, ?> exceptions) {
        this.exceptions = exceptions;
    }
    public List<?> getList() {
        return list;
    }
    public void setList(List<?> list) {
        this.list = list;
    }
}
