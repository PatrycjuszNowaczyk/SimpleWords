package frameapp;

import java.io.*;
import javax.swing.*;


public class WordBase extends JFrame {
        
        private static int textFileLinesNr;
        private static BufferedReader reader;
        private static File textFile;
        private static boolean textFileLoaded = false;
        private static String answerLine="";
        private static String questionLine;
        
    public void loadTextFile() throws FileNotFoundException, IOException{
        JFileChooser chooseFile = new JFileChooser();
        chooseFile.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int tmp = chooseFile.showOpenDialog(rootPane);
        if(tmp == 0){
        textFile = new File(chooseFile.getSelectedFile().getPath());
        reader = new BufferedReader(new FileReader(textFile));
        textFileLoaded = true;
        textFileLinesNr = setLinesNr();
        System.out.println("File is loaded.");
        System.out.println("Does file exists: " + textFile.exists());
        System.out.println("File path: " + chooseFile.getSelectedFile().getPath());
        System.out.println("Lines in file: " + textFileLinesNr);
    }   
        else if (tmp == 1){
            System.out.println("Cancel");
        }
}
    
    private int setLinesNr() throws IOException{
        int nr=0;
        while(reader.readLine()!=null){
            nr++;
        }
        reader.close();
        reader = new BufferedReader(new FileReader(textFile));
        return nr;
    }
            public int getLinesNr(){
                    return textFileLinesNr;
                }
    
    public static void setAnswerLine() throws IOException{
            answerLine=reader.readLine();
    }
            public static String getAnswerLine(){
                    return answerLine;
                }
        
    public static void setQuestionLine() throws IOException{
            questionLine=reader.readLine();
        }
            public static String getQuestionLine(){
                    return questionLine;
                }
            
            
    public static boolean isFileLoaded(){
            return textFileLoaded;
    }
}