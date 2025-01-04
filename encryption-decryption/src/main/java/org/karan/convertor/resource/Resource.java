package org.karan.convertor.resource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.karan.convertor.pojo.DefaultResponse;
import org.karan.convertor.pojo.FileUploadForm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.logging.Log;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/file/")
@RegisterForReflection
public class Resource {

    @Inject
    ProducerTemplate camelProcessingTemplate;

    @POST
    @Path("sign/withpfx")
    @Consumes("multipart/form-data")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSignResponse(@MultipartForm FileUploadForm apiRequest, @HeaderParam("X-Request-ID") String requestId) {
        Log.info("Process Started: Headers: RequestId "+requestId+" , Body "+apiRequest.getDescription().toString());
        Map<String, Object> headers = new HashMap<>();
        headers.put("X-Request-Id", requestId);
        Object responseObject = null;
        DefaultResponse apiResponse = new DefaultResponse();
        try {
            responseObject = camelProcessingTemplate.sendBodyAndHeaders("direct:signfile",
                    ExchangePattern.InOut, apiRequest, headers);
        } catch (CamelExecutionException e) {
            apiResponse.setReturnCode("400");
            apiResponse.setResponseMessage(e.getMessage());
            return Response.status(Response.Status.OK)
                    .entity(apiResponse).build();
        } 
        return Response.status(Response.Status.OK)
                .entity(responseObject).build();

    }
    @POST
    @Path("verify/withpfx")
    @Consumes("multipart/form-data")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    // @Produces(MediaType.APPLICATION_JSON)
    public Response getVerifyResponse(@MultipartForm FileUploadForm apiRequest, @HeaderParam("X-Request-ID") String requestId, @HeaderParam("CamelDigitalSignature") String camelDigitalSignature) {
        Log.debug("Process Started: Headers: RequestId "+requestId+" , Body "+apiRequest.getFile().toString());
        Map<String, Object> headers = new HashMap<>();
        headers.put("X-Request-Id", requestId);
        headers.put("CamelDigitalSignature", camelDigitalSignature);
        Object responseObject = null;
        DefaultResponse apiResponse = new DefaultResponse();
        try {
            responseObject = camelProcessingTemplate.sendBodyAndHeaders("direct:verifyfile",
                    ExchangePattern.InOut, apiRequest, headers);
        } catch (CamelExecutionException e) {
            apiResponse.setReturnCode("400");
            apiResponse.setResponseMessage(e.getMessage());
            return Response.status(Response.Status.OK)
                    .entity(apiResponse).build();
        }
        return Response.status(Response.Status.OK)
                .entity(responseObject).build();

    }
}
