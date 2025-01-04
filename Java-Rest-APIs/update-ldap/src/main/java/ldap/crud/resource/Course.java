package ldap.crud.resource;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.camel.api.management.ManagedNotification;

import io.quarkus.logging.Log;

public class Course {
    private String courseID;
    private String courseName;
    private String courseDuration;
    private String courseLevelId;
    private List<String> memberOf=new ArrayList<>();

    public Course(String courseID, String courseName, String courseDuration, String courseLevelId,List<String> memberOf) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseLevelId = courseLevelId;
        this.memberOf= memberOf;
    }

    public Course() {
    }
    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseDuration() {
        return courseDuration;
    }
    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }
    public String getCourseLevelId() {
        return courseLevelId;
    }
    public void setCourseLevelId(String courseLevelId) {
        this.courseLevelId = courseLevelId;
    }
    public List<String> getMemberOf() {
        return memberOf;
    }
    public void setMemberOf(List<String> memberOf) {
        this.memberOf = memberOf;
    }
    @Override
    public String toString() {
        return "Course [courseID=" + courseID + ", courseName=" + courseName + ", courseDuration=" + courseDuration
                + ", courseLevelId=" + courseLevelId + ", memberOf=" + memberOf + "]";
    }

    public Course(Attributes attributes) throws NamingException {
        this.courseID = attributes.get("courseID").get().toString();
        this.courseName = attributes.get("cn").get().toString();
        this.courseDuration = attributes.get("courseDuration").get().toString();
        this.courseLevelId = attributes.get("courseLevelId").get().toString();
        if(attributes.get("memberOf")!=null){
        NamingEnumeration<?> namingEnumeration= attributes.get("memberOf").getAll();
        while(namingEnumeration.hasMore()){
            this.memberOf.add(namingEnumeration.next().toString());
        }
    }
        
    }
    
}
