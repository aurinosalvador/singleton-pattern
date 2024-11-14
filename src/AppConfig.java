import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Aurino Salvador
 */
public class AppConfig {

    private static AppConfig instance;
    private final Properties properties;

    private AppConfig() {
        properties = new Properties();
        loadProperties();
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader()
                                           .getResourceAsStream(
                                                   "config.properties")) {
            if (input == null) {
                System.out.println("Configuração não encontrada.");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getAppName() {
        return getProperty("app.name");
    }

    public String getAppVersion() {
        return getProperty("app.version");
    }

    public String getAppDescription() {
        return getProperty("app.description");
    }

}
