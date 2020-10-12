package best.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "E:\\INFORMATICS\\Projects_Java_2\\FileConversion\\";
        String fileName = "text.txt";
        double averageNumbersFile;
        averageNumbersFile = convertFile(path+fileName, 20);
        System.out.println("Average of all numbers in file: " + averageNumbersFile);
    }

    public static double convertFile(String fullFileName, int limitSights){
        List<String> lines = ReadSaveFileList.readFileIntoList(fullFileName);
        List<String> newLines = new ArrayList<>();
        int sumNumbersInFile = 0;
        int numbersInFile = 0;
        for (var j = 0; j < lines.size(); j++){
            String line = lines.get(j);
            if(line.length() > limitSights){
                List<String> signList = Arrays.asList(line.split(""));
                StringBuilder newLine = new StringBuilder();
                for(int i = 0; i < signList.size(); i++){
                    String sign = signList.get(i);
                    String newSign = changeChar(sign, i);
                    if(isNumeric(newSign)){
                        sumNumbersInFile += Integer.parseInt(newSign);
                        numbersInFile++;
                    }
                    newLine.append(newSign);
                }
                if(j % 3 == 0){
                    newLine.reverse();
                }
                newLines.add(newLine.toString());
            }
        }
        ReadSaveFileList.saveListIntoFile(newLines, fullFileName);
        if(numbersInFile == 0){
            return 0;
        } else {
            return sumNumbersInFile * 1D / numbersInFile;
        }
    }

    public static String changeChar(String sign, int iterationNr){
        if(iterationNr % 2 == 0) {
            char c = sign.charAt(0);
            c += 1;
            return Character.toString(c);
        } else {
            return sign;
        }
    }

    public static boolean isNumeric(String sign){
        if(sign == null){
            return false;
        }
        try{
            Integer.parseInt(sign);
            System.out.println(sign);
        } catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }
}


