package ldap.crud;

import org.apache.camel.BeanScope;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import static org.apache.camel.model.rest.RestParamType.body;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ldap.crud.resource.BeanFile;
import ldap.crud.resource.Course;
import ldap.crud.resource.CourseList;
import ldap.crud.resource.MessageCourse;
@ApplicationScoped
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        String str=new ArrayList<Course>().getClass().toString();
        restConfiguration()
        .component("servlet")
        .bindingMode(RestBindingMode.off)
        .dataFormatProperty("prettyPrint", "true")
        .enableCORS(true)
        // turn on openapi api-doc
        .apiContextPath("/api-doc")
        .apiProperty("api.title", "LDAP CRUD Operations API")
        .apiProperty("api.version", "1.0.0")
        .apiHost("localhost")
        ;


        onException(com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException.class,org.apache.camel.InvalidPayloadException.class)
        .handled(true)
        .setBody(simple("${exception.message}"))
        .setHeader(Exchange.HTTP_RESPONSE_CODE,constant("400")).stop();



        rest("/v1/ldap/data/institute/course")
        .put().type(Course.class)
        .consumes("application/json")
        .produces("application/json")
        .param().name("body").type(body).description("The course to update").endParam()
        .responseMessage().code(200).message("update success message").endResponseMessage()
        .enableCORS(true)
        .to("direct:putCourse");

        rest("/v1/ldap/data/institute/course")
        .post()
        .type(Course.class)
        .consumes("application/json")
        .produces("application/json")
        .param().name("body").type(body).description("The course to insert").endParam()
        .responseMessage().code(200).message("insert success message").endResponseMessage()
        .enableCORS(true)
        .to("direct:postCourse");

        rest("/v1/ldap/data/institute/course/{courseID}")
        .delete()
        .enableCORS(false)
        .to("direct:deleteCourse");

        rest("/v1/ldap/data/institute/course/{courseID}")
        .produces("application/json")
        .get()
        .enableCORS(false)
        .to("direct:getCourse");

        rest("/v1/ldap/data/institute/course")
        .get()
        .outType(Course[].class)
        .produces("application/json")
        .param().name("body").type(body).description("The course to insert").endParam()
        .responseMessage().code(200).message("insert success message").endResponseMessage()
        .apiDocs(true)
        .enableCORS(true)
        .to("direct:getAllCourse");

        rest("/v1/ldap/data/institute/course/bulk")
        .post().type(Course[].class)
        .outType(MessageCourse.class)
        .consumes("application/json")
        .produces("application/json")
        .param().name("body").type(body).description("The Course to insert").endParam()
        .responseMessage().code(200).message("insert success message").endResponseMessage()
        .enableCORS(true)
        .to("direct:allPostCourse");

        from("direct:putCourse")
        .routeId("PutCourseCodeRoute")
        .unmarshal().json(Course.class)
        .log("${body.toString()}")
        .bean (BeanFile.class, "updateCourse(${body})")
        .choice().when(simple("${body} == 'yes'"))
        .setBody(simple("{\"Status\":\"Success\",\"Message\":\"Course Updated\"}"))
        .otherwise()
        .setHeader(Exchange.HTTP_RESPONSE_CODE,constant("400"));

        from("direct:postCourse")
        .routeId("PostCourseCodeRoute")
        .unmarshal().json(Course.class)
        .log("${body.toString()}")
        .bean (BeanFile.class, "insertCourse(${body})")
        .choice().when(simple("${body} == 'yes'"))
        .setBody(simple("{\"Status\":\"Success\",\"Message\":\"Course Inserted\"}"))
        .otherwise()
        .setHeader(Exchange.HTTP_RESPONSE_CODE,constant("400"));

        from("direct:allPostCourse")
        .routeId("PostAllCourseCodeRoute")
        .unmarshal(new ListJacksonDataFormat(Course.class))
        .bean (BeanFile.class, "insertAllCourse(${body})")
        .marshal().json();


        from("direct:deleteCourse")
        .routeId("deleteCourseCodeRoute")
        .bean (BeanFile.class, "deleteCourse(${header.courseID})")
        .choice().when(simple("${body} == 'yes'"))
        .setBody(simple("{\"Status\":\"Success\",\"Message\":\"Course deleted\"}"))
        .setHeader(Exchange.CONTENT_TYPE,constant("application/json"))
        .otherwise()
        .setHeader(Exchange.HTTP_RESPONSE_CODE,constant("400"));


        from("direct:getCourse")
        .routeId("getCourseCodeRoute")
        .bean (BeanFile.class, "getCourse(${header.courseID})")
        .marshal().json();

        from("direct:getAllCourse")
        .routeId("getAllCourseCodeRoute")
        .choice().when(simple("${header.filter} == null"))
        .bean (BeanFile.class, "getFilterCourse({{courseFilterAll}})").endChoice()
        .otherwise()
        .bean (BeanFile.class, "getFilterCourse(${header.filter})")
        .end()
        .marshal().json();


    }
    
}
