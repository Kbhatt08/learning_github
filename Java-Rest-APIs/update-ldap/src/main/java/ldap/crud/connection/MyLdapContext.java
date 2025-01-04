package ldap.crud.connection;

import java.util.Hashtable;
import java.util.Properties;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.Unremovable;
import io.quarkus.runtime.annotations.RegisterForReflection;


@Dependent
@RegisterForReflection
@Unremovable
public class MyLdapContext{

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

    
    

    public InitialLdapContext ldapContext() throws NamingException {
        Properties props=new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldap://"+ ldapHost + ":" + ldapPort);
        props.put(Context.URL_PKG_PREFIXES, "com.sun.jndi.url");
        props.put(Context.REFERRAL, "ignore");
        props.put(Context.SECURITY_AUTHENTICATION, "simple");
        props.put(Context.SECURITY_PRINCIPAL, bindDN);
        props.put(Context.SECURITY_CREDENTIALS, bindPasswd);
        return new InitialLdapContext(props,null);
    }
    
}

