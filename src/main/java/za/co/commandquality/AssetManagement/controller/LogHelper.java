package za.co.commandquality.AssetManagement.controller;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public record LogHelper() {

    private static Logger logger= Logger.getLogger(LogHelper.class.getName());

    public static void loggerFunc(String fileName,Level level) {
        try {
            FileHandler handler;
            handler = new FileHandler(fileName, true );
            logger.addHandler( handler);
            logger.log( level, level.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loggerFunc(String fileName,Level level,Exception ex) {
        try {
            FileHandler handler;
            handler = new FileHandler(fileName, true );
            logger.addHandler( handler);
            logger.log( level, level.getName().toLowerCase()+ Arrays.stream( LogHelper.class.getDeclaredMethods() ).findFirst(),ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
