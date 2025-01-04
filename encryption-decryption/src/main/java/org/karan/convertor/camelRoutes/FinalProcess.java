package org.karan.convertor.camelRoutes;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.attachment.AttachmentMessage;
import org.karan.convertor.pojo.DefaultResponse;

import io.quarkus.logging.Log;

public class FinalProcess {
    public void onComplete(Exchange exchange){
        Message message= exchange.getIn();
        String body= message.getBody().toString();
        String headers= message.getHeaders().toString();
        Log.debug("Process Ended: Headers "+headers+" , Body "+body);
        AttachmentMessage attMsg = exchange.getIn(AttachmentMessage.class);
        exchange.setMessage(attMsg);
    }
    public void onException(Exchange exchange){
        Message message= exchange.getIn();
        String body= message.getBody().toString();
        String headers= message.getHeaders().toString();
        Log.debug("Process Ended: Headers "+headers+" , Body "+body);
        exchange.getIn().setBody(new DefaultResponse("400",exchange.getProperty("CamelExceptionCaught").toString()));
    }
}
