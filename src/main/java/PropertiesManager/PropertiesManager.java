package PropertiesManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

        private static PropertiesManager instance;
        private static final Object lock = new Object();
        private static String propertyFilePath = System.getProperty("user.dir")+
                "\\src\\main\\resources\\URLProperty.properties";
        private static String url;
        private static String username;
        private static String password;

        //Create a Singleton instance. We need only one instance of Property Manager.
        public static PropertiesManager getInstance () {
            if (instance == null) {
                synchronized (lock) {
                    instance = new PropertiesManager();
                    instance.loadData();
                }
            }
            return instance;
        }

        //Get all configuration data and assign to related fields.
        private void loadData() {
            //Declare a properties object
            Properties prop = new Properties();

            //Read configuration.properties file
            try {
                prop.load(new FileInputStream(propertyFilePath));
                //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
            } catch (IOException e) {
                System.out.println("Configuration properties file cannot be found");
            }

            //Get properties from configuration.properties
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        }

        public String getURL () {
            return url;
        }

        public String getUsername () {
            return username;
        }

        public String getPassword () {
            return password;
        }
}
