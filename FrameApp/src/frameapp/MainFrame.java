package frameapp;

import static frameapp.WordBase.*;
import static frameapp.Logic.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class MainFrame extends JFrame {
    
    //Variables
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (((int) screenSize.getWidth())/2 - 400);
        int locationY = (((int) screenSize.getHeight())/2 - 300);
        public static int goodCounter = 0;
        public static int badCounter = 0;
    
    
    //Components
         JPanel jpanel = new JPanel(new FlowLayout());
         public static JLabel question = new JLabel("QUESTION");
         public static JLabel good = new JLabel("GOOD: " + getAnswerLine());
         public static JTextField text = new JTextField("ANSWER");
         JButton bLoadFile = new JButton("LoadFile");
         JButton bExit = new JButton("Exit");
         Container glass = this.getContentPane();
         
    
    
    
    
    public final void initComponent(){
        
        glass.add(jpanel, BorderLayout.CENTER);
        jpanel.setLayout(null);
        jpanel.setBackground(new Color(70,80,70));
        
        
        


        text.setHorizontalAlignment(JTextField.CENTER);
        text.setSize(750,100);
        text.setFont(new Font("MS Sans Serif", Font.BOLD,20));
        text.setForeground(new Color(70,80,70));
        text.setBackground(new Color(230,240,230));
        text.setLocation(25,250);
        text.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        text.addActionListener((ActionEvent e) -> {
            try {
                checkAnswer();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bLoadFile.setSize(100, 25);
        bLoadFile.setLocation(300, 450);
        bLoadFile.setBackground(new Color(70,80,70));
        bLoadFile.setForeground(new Color(230,240,230));
        bLoadFile.setBorderPainted(true);
        bLoadFile.setFocusPainted(false);
        bLoadFile.setContentAreaFilled(false);
        bLoadFile.addActionListener((ActionEvent e) -> {
                WordBase loadFile = new WordBase();
                text.setText("");
                try {
                    loadFile.loadTextFile();
                    setAnswerLine();
                    setQuestionLine();
                    
                    question.setText(getQuestionLine());
                    
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
        bExit.setSize(100, 25);
        bExit.setLocation(425, 450);
        bExit.addActionListener( e -> System.exit(0));
        bExit.setBackground(new Color(70,80,70));
        bExit.setForeground(new Color(230,240,230));
        bExit.setBorderPainted(true);
        bExit.setFocusPainted(false);
        bExit.setContentAreaFilled(false);
        jpanel.add(bLoadFile, BorderLayout.PAGE_END);
        jpanel.add(bExit, BorderLayout.PAGE_END);
        jpanel.add(text);
        jpanel.add(question);
        jpanel.add(good);
        question.setHorizontalAlignment(JTextField.CENTER);
        question.setSize(750,100);
        question.setFont(new Font("MS Sans Serif", Font.BOLD,20));
        question.setForeground(new Color(230,240,230));
        question.setLocation(25,100);
        
        
//                //TEST GOOD COUNTER 
//        good.setSize(200,50);
//        good.setFont(new Font("MS Sans Serif", Font.BOLD,14));
//        good.setLocation(25,550);
//        good.setForeground(new Color(230,240,230));
//        //END TEST GOOD COUNTER
    }
    
    //Methods
    public MainFrame(){
        super("..::Cards:::....");
        initComponent();
        super.setUndecorated(true);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(800, 600);
        super.setLocation(locationX, locationY);
        super.setResizable(false);
//        super.pack();
//        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    
    

    
}