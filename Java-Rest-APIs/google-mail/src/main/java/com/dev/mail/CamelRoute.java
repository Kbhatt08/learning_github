package com.dev.mail;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.google.mail.internal.GoogleMailApiName;

public class CamelRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        
        rest("/mail")
        .enableCORS(true)
        .post()
        .to("direct:mail");

        from("direct:mail")
        .unmarshal().json(Messagein.class)
        .log("${body.getEmailId}")
        .setHeader("subject", simple("${body.getSubject}"))
		.setHeader("to", simple("${body.getEmailId}"))
        .setBody(simple("${body.getBody}"))
        .setHeader("contentType",simple("text/html"))
		.to("smtps://smtp.gmail.com:465?username=bhattkaran071@gmail.com&password=demopass")
        .log("done");
    }
}
