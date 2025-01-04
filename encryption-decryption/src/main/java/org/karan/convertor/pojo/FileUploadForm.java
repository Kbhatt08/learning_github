package org.karan.convertor.pojo;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.vertx.ext.web.multipart.MultipartForm;

import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RegisterForReflection 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FileUploadForm {

    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream file;

    @FormParam("description")
    @PartType(MediaType.TEXT_PLAIN)
    public String description;
}

