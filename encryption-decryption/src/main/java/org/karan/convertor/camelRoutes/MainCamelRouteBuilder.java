package org.karan.convertor.camelRoutes;

import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.crypto.DigitalSignatureConfiguration;
// import org.apache.camel.opentelemetry.OpenTelemetryTracer;
// import org.apache.camel.opentelemetry.OpenTelemetryTracingStrategy;
import org.apache.camel.component.crypto.DigitalSignatureConstants;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.jcajce.provider.frodo.BCFrodoPrivateKey;
import org.karan.convertor.pojo.DefaultResponse;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MainCamelRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // CamelContext camelContext = this.getCamelContext();
        // OpenTelemetryTracer oTracingTracer = new OpenTelemetryTracer();
        // oTracingTracer.setTracingStrategy(new OpenTelemetryTracingStrategy(oTracingTracer));
        // oTracingTracer.init(camelContext);


        onCompletion().bean(FinalProcess.class,"onComplete");
        onException(java.security.SignatureException.class)
        .handled(true)
        .log(LoggingLevel.ERROR, "Error while signing ${exception}").bean(FinalProcess.class,"onException");
        ;

            from("direct:signfile")
            .log(LoggingLevel.INFO, "Entering Camel Route: Headers ${headers} , Body ${body}")
            .routeId("signfile")
            .setBody(simple("${body.file}"))
            .to("crypto:sign:esign?keystore=#keystore&password=hellokeen")
            .setBody(simple("${header.CamelDigitalSignature}"))
            .log(LoggingLevel.INFO, "Exiting Camel Route: Headers ${headers} , Body ${body}");

            from("direct:verifyfile")
            .log(LoggingLevel.INFO, "Entering Camel Route: Headers ${headers} , Body ${body}")
            .routeId("verifyfile")
            .setBody(simple("${body.file}"))
            .to("crypto:verify:esign?keystore=#keystore&password=hellokeen")
            .log("${headers}")
            .setHeader("Content-Disposition", simple("attachment;filename=classes.jar"))
            .marshal().mimeMultipart()
            .log(LoggingLevel.INFO, "Exiting Camel Route: Headers ${headers} , Body ${body.class}");
        }
    

}
