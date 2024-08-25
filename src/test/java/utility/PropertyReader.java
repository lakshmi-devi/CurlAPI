package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {

        static String value = null;

        public static String propertyReader(String filePath, String key) {
            try(InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
                Properties prop = new Properties();
                prop.load(inputStream);
                value = prop.getProperty(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return value;
        }
    }

