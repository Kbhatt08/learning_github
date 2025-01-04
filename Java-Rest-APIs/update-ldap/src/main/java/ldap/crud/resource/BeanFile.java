package ldap.crud.resource;

import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.Handler;
import org.apache.camel.component.rest.openapi.RestOpenApiComponent;
import org.apache.camel.language.bean.Bean;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.Unremovable;
import io.quarkus.logging.Log;
import ldap.crud.connection.MyLdapConnection;
import ldap.crud.connection.MyLdapContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import java.util.List;
import java.util.Map;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
@ApplicationScoped
@Unremovable
public class BeanFile {
@Inject
MyLdapContext myLdapContext;

@ConfigProperty(name="coursebase")
String courseBase;
@ConfigProperty(name="courseProp1")
String courseProp1;
@ConfigProperty(name="courseProp2")
String courseProp2;
@ConfigProperty(name="courseProp3")
String courseProp3;
@ConfigProperty(name="courseProp4")
String courseProp4;
@ConfigProperty(name="courseProp5")
String courseProp5;
@ConfigProperty(name="courseProp6")
String courseProp6;
@ConfigProperty(name="courseObjectClass")
String courseProp6Value;
@ConfigProperty(name="courseFilterAll")
String courseFilterAll;
@ConfigProperty(name="courseSearchLevel")
Integer courseSearchLevel;

    private BeanFile() {
        //constructor
    }
    @Handler
    public String updateCourse(Course body) throws NamingException {

    ModificationItem item = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(courseProp2, body.getCourseName()));
    ModificationItem item1 = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(courseProp3, body.getCourseDuration()));
    ModificationItem item2 = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(courseProp4, body.getCourseLevelId())); 
    try {
        myLdapContext.ldapContext().modifyAttributes(courseProp1+"="+body.getCourseID() +","+courseBase, new ModificationItem[] {item,item1,item2});    
    } catch (Exception e) {
        Log.error(e.toString());
        return(e.toString());
    }
    myLdapContext.ldapContext().close();
    Log.info("action Completed");
    return("yes");
    }  

    @Handler
    public String insertCourse(Course body) throws NamingException {

    Attributes attributes=new BasicAttributes();
    attributes.put(courseProp1, body.getCourseID());
    attributes.put(courseProp2, body.getCourseName());
    attributes.put(courseProp3, body.getCourseDuration());
    attributes.put(courseProp4, body.getCourseLevelId());
    ModificationItem[] mods=new ModificationItem[body.getMemberOf().size()];
    for(int i=0;i<body.getMemberOf().size();i++){
        mods[i]=new ModificationItem(DirContext.ADD_ATTRIBUTE, new BasicAttribute(courseProp5, body.getMemberOf().get(i)));
    }
    attributes.put(courseProp6, courseProp6Value);
    try {
        myLdapContext.ldapContext().createSubcontext(courseProp1+"="+body.getCourseID()+","+courseBase, attributes);  
        myLdapContext.ldapContext().modifyAttributes(courseProp1+"="+body.getCourseID()+","+courseBase, mods);  
    } catch (Exception e) {
        Log.error(e.toString());
        return(e.toString());
    }finally{
        myLdapContext.ldapContext().close();
    }
    myLdapContext.ldapContext().close();
    Log.info("action Completed");
    return("yes");
    }

    @Handler
    public MessageCourse insertAllCourse(List<Course> body) throws NamingException {
    Log.info("here");    
    List<Course> conflictList=new ArrayList<>();
    Map<String,Course> conflictMap=new HashMap<>();
    for(Course course:body){
    Attributes attributes=new BasicAttributes();
    attributes.put(courseProp1, course.getCourseID());
    attributes.put(courseProp2, course.getCourseName());
    attributes.put(courseProp3, course.getCourseDuration());
    attributes.put(courseProp4, course.getCourseLevelId());
    ModificationItem[] mods=new ModificationItem[course.getMemberOf().size()];
    for(int i=0;i<course.getMemberOf().size();i++){
        mods[i]=new ModificationItem(DirContext.ADD_ATTRIBUTE, new BasicAttribute(courseProp5, course.getMemberOf().get(i)));
    }
    attributes.put(courseProp6, courseProp6Value);
    try {
        myLdapContext.ldapContext().createSubcontext(courseProp1+"="+course.getCourseID()+","+courseBase, attributes);    
    } catch (Exception e) {
        Log.error(e.toString());
        conflictList.add(course);
        conflictMap.put(e.toString(), course);
    }
    }
    String status;
    if(conflictList.isEmpty()){
        status="success";
    }
    else{
        status=conflictList.size()+" errors";
    }
    MessageCourse messageCourse=new MessageCourse(status, conflictMap, conflictList);
    myLdapContext.ldapContext().close();
    Log.info("action Completed");
    return(messageCourse);
    }

    @Handler
    public String deleteCourse(String courseID) throws NamingException {

    try {
        Log.info(myLdapContext.ldapContext().lookup(courseProp1+"="+courseID+","+courseBase));
        myLdapContext.ldapContext().destroySubcontext(courseProp1+"="+courseID+","+courseBase);   
    } catch (Exception e) {
        Log.error(e.toString());
        return(e.toString());
    }
    myLdapContext.ldapContext().close();
    Log.info("action Completed");
    return("yes");
    }

    @Handler
    public Course getCourse(String courseID) throws NamingException {
    try {
        Attributes attributes= myLdapContext.ldapContext().getAttributes(courseProp1+"="+courseID+","+courseBase);
        Log.info(attributes.toString());
        return new Course(attributes); 
    } catch (Exception e) {
        Log.error(e.toString());
        return new Course();
    }
    }

    @Handler
    public List<Course> getFilterCourse(String body) throws NamingException {
    List<Course> responseList= new ArrayList<>();
    try {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(courseSearchLevel);
        Log.info("filter is: "+body);
        NamingEnumeration<SearchResult> sEnumeration = myLdapContext.ldapContext().search(courseBase, body,searchControls);
        Log.info(sEnumeration);
        while(sEnumeration.hasMore()){
            Attributes attributes = sEnumeration.next().getAttributes();
            Course  st= new Course(attributes);   
            responseList.add(st);
        }
        return responseList;
    } catch (Exception e) {
        Log.error(e.toString());
        return responseList;
    }
    }
  

}

