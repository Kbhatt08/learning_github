package ldap.crud.resource;

import java.util.ArrayList;

import java.util.List;

public class CourseList {
    private List<Course> bulk=new ArrayList<>();

    public CourseList() {
    }

    public CourseList(List<Course> bulk) {
        this.bulk = bulk;
    }

    public List<Course> getBulk() {
        return bulk;
    }

    public void setBulk(List<Course> bulk) {
        this.bulk = bulk;
    }
}
