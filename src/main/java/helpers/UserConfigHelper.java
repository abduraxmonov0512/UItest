package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserConfigHelper {
    Properties property = new Properties();
    FileInputStream fis;

    private void loadUserConfig(){
        try {
            fis = new FileInputStream("src/test/resources/users.properties");
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLoginUser(String user){
        loadUserConfig();
        return property.getProperty(user);
    }

    public String getPasswordUser(String password){
        loadUserConfig();
        return property.getProperty(password);
    }

}

