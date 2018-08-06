package PropertiesManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

        private static PropertiesManager instance;
        private static final Object lock = new Object();
        private static String propertyFilePath = System.getProperty("user.dir")+
                "\\src\\main\\resources\\URLProperty.properties";
    private static String propertyFilePath2 = System.getProperty("user.dir")+
            "\\src\\main\\resources\\LoginProperty.properties";
        private static String urlAlda;
        private static String usernameAlda;
        private static String passwordAlda;
        private static String urlWedos;
        private static String usernameWedos;
        private static String passwordWedos;

        //Create a Singleton instance. We need only one instance of Property Manager.
        public static PropertiesManager getInstance () {
            if (instance == null) {
                synchronized (lock) {
                    instance = new PropertiesManager();
                    instance.loadURLData();
                    instance.loadLoginData();
                }
            }
            return instance;
        }

        //Get all configuration data and assign to related fields.
        private void loadURLData() {
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
            urlAlda = prop.getProperty("urlAlda");
            urlWedos = prop.getProperty("urlWedos");
        }
    private void loadLoginData() {
        //Declare a properties object
        Properties prop = new Properties();

        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath2));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        //Get properties from configuration.properties
        usernameAlda = prop.getProperty("usernameAlda");
        passwordAlda = prop.getProperty("passwordAlda");
        usernameWedos = prop.getProperty("usernameWedos");
        passwordWedos = prop.getProperty("passwordWedos");
    }

        public String getURLAlda() {
            return urlAlda;
        }

        public String getUsernameAlda() {
            return usernameAlda;
        }

        public String getPasswordAlda() {
            return passwordAlda;
        }

        public String getURLWedos() {
        return urlWedos;
    }

        public String getUsernameWedos() {
        return usernameWedos;
    }

        public String getPasswordWedos() {
        return passwordWedos;
    }
}
