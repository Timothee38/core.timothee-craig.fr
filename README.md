# timothee-craig.fr API

Reworking my personal website using more recent technologies. 
There will be a front-end, visible to all user and a back-end, only for me.

The front-end will be quite similar to what it is right now, but it would be loading dynamically.
As for the back-end, I'm going to create an admin.timothee-craig.fr from which I can edit the data of my website easily, and monitor the amount of visitors, etc.

The application will also use a REST API, which is this project. It uses JWT for authentication. 

If you're running the project, you'll have to add the SecurityConstants file again...

Format is: 
    
    package fr.timotheecraig.core.security;
    
    public class SecurityConstants {
        public static final String SECRET = "YOUR SECRET FOR JWT";
        public static final long EXPIRATION_TIME = 864_000_000; // 10 days
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String HEADER_STRING = "Authorization";
        public static final String IP_STACK_API_KEY = "IPSTACK.COM API KEY";
    }

To deploy the project, use maven and create a jar. You can then run the jar using the following command:
    
    java -jar <projectname> --spring.config.location=/path/to/property.properties
    
