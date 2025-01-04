package ldap.crud.connection;

import javax.inject.Named;
import org.apache.directory.ldap.client.api.DefaultLdapConnectionFactory;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import javax.inject.Singleton;
import javax.enterprise.inject.Produces;

import io.quarkus.arc.Unremovable;
import io.quarkus.logging.Log;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@Singleton
@Unremovable
public class MyLdapConnectionfactory {
    
    @ConfigProperty(name="ldapHost")
    String ldapHost;

    @ConfigProperty(name="ldapPort")
    int ldapPort;

    @ConfigProperty(name="bindDN")
    String bindDN;

    @ConfigProperty(name="bindPasswd")
    String bindPasswd;

    @ConfigProperty(name="ldapTimeOut")
    long connectionTimeOut;

    
    public MyLdapConnectionfactory() {
    }


    @Produces
    @Named("myLdapConnectionFactory")
    public DefaultLdapConnectionFactory defaultLdapConnectionFactory() {
        Log.info(ldapHost+"   "+ldapPort+" "+bindDN+" "+bindPasswd+" "+connectionTimeOut);
        LdapConnectionConfig ldapConfig = new LdapConnectionConfig();
        ldapConfig.setLdapHost(ldapHost);
        ldapConfig.setLdapPort(ldapPort);
        ldapConfig.setName(bindDN);
        ldapConfig.setCredentials(bindPasswd);
        ldapConfig.setTimeout(connectionTimeOut);
        //ldapConfig.setUseSsl(false);
        //ldapConfig.setUseTls(false);
        return new DefaultLdapConnectionFactory(ldapConfig);

    }    
}
