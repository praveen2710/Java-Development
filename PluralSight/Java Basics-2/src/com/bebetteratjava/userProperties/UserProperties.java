package com.bebetteratjava.userProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * This class will initially load default values and then change them to user specific values
 * Created by pb033954 on 3/28/2017.
 */
public class UserProperties {
    public static void main (String args[]){
        Properties defaultProp = new Properties();
        try {
            try(InputStream inputStream = UserProperties.class.getResourceAsStream("MyDefault.xml")){
                defaultProp.loadFromXML(inputStream);
            }
            Properties userProps = new Properties(defaultProp);
            loadUserProps(userProps);

            String welcomeMessage = userProps.getProperty("welcomeMessage");
            String farewellMessage = userProps.getProperty("farewellMessage");
            System.out.println(welcomeMessage);
            System.out.println(farewellMessage);
            if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")){
                userProps.setProperty("welcomeMessage","Welcome back");
                userProps.setProperty("farewellMessage","Things will be familiar now");
                saveuserProps(userProps);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveuserProps(Properties userProps) throws IOException {
        try(OutputStream outputStream = Files.newOutputStream(Paths.get("userValues.xml"))){
            userProps.storeToXML(outputStream,"User custom values");
        }
    }

    private static Properties loadUserProps(Properties userProps) throws IOException {
        Path userFile = Paths.get("userValues.xml");
        if(Files.exists(userFile)){
            try(InputStream inputStream = Files.newInputStream(userFile)){
                userProps.loadFromXML(inputStream);
            }
        }
        return userProps;
    }
}
