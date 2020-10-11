package best.programming;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "E:\\INFORMATICS\\Projects_Java_2\\FileConversion\\";
        String fileName = "text.txt";
        convertFile(path+fileName, 20);
    }

    public static double convertFile(String fullFileName, int limitSights){
        List<String> lines = ReadFileIntoList.readFileIntoList(fullFileName);
        int sumNumbersInFile = 0;
        int numbersInFile = 0;
        for (var j = 0; j < lines.size(); j++){
            String line = lines.get(j);
            if(line.length() > limitSights){
                List<String> signList = Arrays.asList(line.split(""));
                StringBuilder newLine = new StringBuilder();
                for(int i = 0; i < signList.size(); i += 2){
                    String sign = signList.get(i);
                    try{
                        sumNumbersInFile += Integer.parseInt(sign);
                        numbersInFile++;
                    } catch(NumberFormatException e){};
                    char c = sign.charAt(0);
                    c += 1;
                    newLine.append(c);
                }
                if(j % 3 == 0){
                    newLine.reverse();
                }
            }
        }
        return sumNumbersInFile * 1D /numbersInFile;
    }
}
