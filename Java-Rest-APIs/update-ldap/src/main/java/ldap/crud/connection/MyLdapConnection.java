package ldap.crud.connection;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;


import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.ldap.client.api.LdapConnection;


import io.quarkus.runtime.annotations.RegisterForReflection;

@Dependent
@RegisterForReflection
public class MyLdapConnection {
    
    @Inject
    MyLdapConnectionfactory myLdapConnectionFactory;

    

    @Produces
    @Dependent
    @Named("MyLdapConnection")
    public LdapConnection ldapConnection() throws LdapException {
        
        return myLdapConnectionFactory.defaultLdapConnectionFactory().newLdapConnection();
    }
    

    
}