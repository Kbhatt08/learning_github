package org.karan.convertor.camelRoutes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;

import io.quarkus.arc.Unremovable;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import lombok.NoArgsConstructor;

@ApplicationScoped
public class KeystoreConfig {
    @Named("keystore")
    public KeyStore myKeystore() throws Exception {
        KeyStore store = KeyStore.getInstance(new File("src/main/resources/cert.pfx"), "hellokeen".toCharArray());
        return store;
    }
}
