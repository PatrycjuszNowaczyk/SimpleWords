package frameapp;

import static frameapp.MainFrame.*;
import static frameapp.WordBase.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class Logic {
  
    
    public static void checkAnswer() throws IOException{

        if (isFileLoaded()==false){
        question.setText("PLEASE LOAD BASE FILE FIRST");
        text.setText("");
        System.out.println("File isn't loaded.");
        }
        
        else if(isFileLoaded()==true){
            
            if(text.getText().equals(getAnswerLine())){
                goodCounter++;
                }
            else{
                if(getAnswerLine()==null){
                    System.out.println("End of file");
                }
                //Show bad answer message 
                else{
                badCounter++;
                System.out.println(badCounter);
                UIManager.put("OptionPane.background", new Color(140,70,70));     
                UIManager.put("OptionPane.messageForeground", new Color(230,240,230));     
//                UIManager.setLookAndFeel();
                UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(140,70,70));
                JOptionPane.showMessageDialog(new JFrame(),
                getAnswerLine(),
                "Right answer is:",
                JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            text.setText("");
            
            if(getAnswerLine() != null){
            setAnswerLine();
            setQuestionLine();
            question.setText(getQuestionLine());
            System.out.println("Answer is: " + getAnswerLine());

                System.out.println(goodCounter);
            }
            else{
                question.setText("THAT'S ALL");
            }
        }
    }
    
    
}