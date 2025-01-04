package Routes;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        rest("/hello")
        .get().to("direct:hello");

        from("direct:hello")
        .delay(simple("{{delay_time}}"))
        .setBody(simple("Hello from Camel"));
    }
    
}
