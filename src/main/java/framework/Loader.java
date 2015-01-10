package framework;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;
import java.io.IOException;

/**
 * Created by sstep on 12/22/2014.
 */
public class Loader {
    private static final String propFile = "../Rozetka.properties";
    static Properties proper = new Properties();

    public static String loadProperty(String name) {

        try {
            proper.load(Loader.class.getResourceAsStream(propFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";
        if (name != null) {
            value = proper.getProperty(name);
        }
        return value;
    }

    //add new properties to file
    /*public static void reloadProperty(String text){
        try {
            proper.store(PropertyLoader.class.getResourceAsStream(propFile),String t);
        } catch (IOException e) {
            e.printStackTrace();
        }
            proper.setProperty("res",text);
    }*/

    public static void writeToFile(String text) {
        FileWriter fileWriter=null;
        try {
            File resultFile = new File("resultFile.txt");
            fileWriter = new FileWriter(resultFile,true);
            fileWriter.append(text+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
