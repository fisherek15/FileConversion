package best.programming;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadSaveFileList {

    public static List<String> readFileIntoList(String fileName) {
        List<String> lines = Collections.emptyList();
        try{
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (NoSuchFileException e1) {
            System.out.println("There is no such file.");
            createNewFile(fileName);
            System.exit(1);
        } catch (IOException e2){
            e2.printStackTrace();
            System.exit(1);
        }
        return lines;
    }

    public static void saveListIntoFile(List<String> list, String fileName){
        try{
            Files.write(Paths.get(fileName), list);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

    public static void createNewFile(String fileName){
        try{
            File file = new File(fileName);
            if(file.createNewFile()){
                System.out.println("File created");
                List<String> list = new ArrayList<>();
                list.add("Lack of an input file.");
                saveListIntoFile(list, fileName);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
