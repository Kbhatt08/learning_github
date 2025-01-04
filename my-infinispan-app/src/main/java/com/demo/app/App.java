package com.demo.app;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
// import org.infinispan.configuration.cache.ConfigurationBuilder;
// import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.DefaultCacheManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // Define the HotRod server address and port
        String serverAddress = "localhost";
        int serverPort = 11222;
        int connectionTimeOut=10000;

        ConfigurationBuilder clientBuilder = new ConfigurationBuilder();
        // clientBuilder.uri("hotrod://admin:password@192.168.1.234:11222?auth_realm=default&sasl_mechanism=PLAIN");
        int socketTimeOut=10000;
        int maxRetry=2;
        Configuration con = clientBuilder.addServer().host(serverAddress).port(11222).security().authentication().username("admin").password("password").connectionTimeout(connectionTimeOut).socketTimeout(socketTimeOut).maxRetries(maxRetry).build();
        
        // Create a default cache manager
        RemoteCacheManager cacheManager = new RemoteCacheManager(con);
        cacheManager.start();

        // Obtain the cache using HotRod
        RemoteCache<String, String> cache = cacheManager.getCache("democache");


        // Put some data into the cache (for demonstration purposes)
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        // Retrieve data from the cache
        String value1 = cache.get("key1");
        String value2 = cache.get("key2");

        // Display the retrieved values
        System.out.println("Value for key1: " + value1);
        System.out.println("Value for key2: " + value2);

        // Stop the cache manager
        cacheManager.stop();

    }
}
