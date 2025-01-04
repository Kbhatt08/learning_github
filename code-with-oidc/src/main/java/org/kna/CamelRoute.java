package org.kna;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class CamelRoute extends RouteBuilder{

    

    @Override
    public void configure() throws Exception {

        restConfiguration()
        .component("servlet")
        .bindingMode(RestBindingMode.auto)
        .dataFormatProperty("prettyPrint", "true")
        .enableCORS(true)
        // turn on openapi api-doc
        .apiContextPath("/api-doc")
        .apiProperty("api.title", "OIDC API")
        .apiProperty("api.version", "1.0.0")
        .apiHost("localhost");
        
        rest("/token")
        .post()
        .apiDocs(true)
        .consumes("application/json")
        .produces("application/json").outType(TokenResponse.class)
        .to("direct:token");

        from("direct:token")
        .setBody(exchange-> new TokenResponse("abc", "jh", "jj", "8987"))
        .log("Response: ${body}");

        rest("/api")
        .post()
        .apiDocs(true)
        .consumes("application/json")
        .produces("application/json").outType(TokenResponse.class)
        .to("direct:api");

        from("direct:api")
        .log("input headers: ${headers}")
        .choice().when(simple("${header.x-auth-token} == 'abc'"))
        .setBody(simple("response with token"))
        .otherwise()
        .setBody(simple("response without token"))
        .end()
        .log("Response: ${body}");
    }
    
}
