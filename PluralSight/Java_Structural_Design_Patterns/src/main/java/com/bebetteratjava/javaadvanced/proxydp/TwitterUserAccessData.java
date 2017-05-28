package com.bebetteratjava.javaadvanced.proxydp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by PB033954 on 5/28/2017.
 */
public class TwitterUserAccessData {

    private final String twitterAccessToken,twitterAccessTokenSecret,twitterSecretKey,twitterConsumerKey;

    public TwitterUserAccessData( String twitterConsumerKey,String twitterSecretKey,String twitterAccessToken, String twitterAccessTokenSecret) {
        this.twitterAccessToken = twitterAccessToken;
        this.twitterAccessTokenSecret = twitterAccessTokenSecret;
        this.twitterSecretKey = twitterSecretKey;
        this.twitterConsumerKey = twitterConsumerKey;
    }

    /**
     * This method will load the key,value tokens in properties files
     */
    public void setAccessDataInProperties(){
        Properties prop = new Properties();
//        OutputStream output = null;
        try(OutputStream output =new FileOutputStream("config.properties");) {

            // set the properties value
            prop.setProperty("TWITTER_ACCESS_TOKEN",this.twitterAccessToken);
            prop.setProperty("TWITTER_ACCESS_TOKEN_SECRET",this.twitterAccessTokenSecret);
            prop.setProperty("TWITTER_SECRET_KEY",this.twitterSecretKey);
            prop.setProperty("TWITTER_CONSUMER_KEY",this.twitterConsumerKey);

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
