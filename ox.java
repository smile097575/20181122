import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ox extends JFrame {
    Container cp;
    private JButton jbtn1 = new JButton();
    private JButton jbtn2 = new JButton();
    private JButton jbtn3 = new JButton();
    private JButton jbtn4 = new JButton();
    private JButton jbtn5 = new JButton();
    private JButton jbtn6 = new JButton();
    private JButton jbtn7 = new JButton();
    private JButton jbtn8 = new JButton();
    private JButton jbtn9 = new JButton();
    private JLabel jlb1 = new JLabel("game");
    private JPanel jpan= new JPanel(new GridLayout(3,3,3,3));
    private int x = 0;
    MainFrame MF ;

    public ox(MainFrame MF1) {
        MF = MF1;
        ex1();
    }

    private void ex1() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 500);
        cp = this.getContentPane();
        cp.add(jpan,BorderLayout.CENTER);
        cp.add(jlb1,BorderLayout.NORTH);
        jlb1.setBackground(new Color(255, 164, 209));
        jlb1.setFont(new Font(null,Font.BOLD,50));
        jlb1.setOpaque(true);

        jpan.add(jbtn1);
        jpan.add(jbtn2);
        jpan.add(jbtn3);
        jpan.add(jbtn4);
        jpan.add(jbtn5);
        jpan.add(jbtn6);
        jpan.add(jbtn7);
        jpan.add(jbtn8);
        jpan.add(jbtn9);

        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }
        });
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }
        });
        jbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }

        });
        jbtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }
        });

        jbtn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }
        });
        jbtn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }
        });
        jbtn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }

        });
        jbtn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }
        });
        jbtn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tembtn = (JButton)e.getSource();
                if (x%2==0){
                    tembtn.setText("o");
                }else {
                    tembtn.setText("x");
                }
                x++;
                tembtn.setEnabled(false);
                check();
            }
        });

    }
    private void check(){
        if (jbtn1.getText().equals(jbtn2.getText())&&jbtn2.getText().equals(jbtn3.getText())&&!jbtn1.getText().equals("")){
         if (jbtn1.getText().equals("o")){
             jlb1.setText("player1 win");
         }else {
             jlb1.setText("player2 win");
         }
        }
        if (jbtn1.getText().equals(jbtn5.getText())&&jbtn5.getText().equals(jbtn9)&&!jbtn1.getText().equals("")){
            if (jbtn1.getText().equals("o")){
                jlb1.setText("player1 win");
            }else {
                jlb1.setText("player2 win");
            }
        }
        if (jbtn1.getText().equals(jbtn4.getText())&&jbtn4.getText().equals(jbtn7)&&!jbtn1.getText().equals("")){
            if (jbtn1.getText().equals("o")){
                jlb1.setText("player1 win");
            }else {
                jlb1.setText("player2 win");
            }
        }
        if (jbtn2.getText().equals(jbtn5.getText())&&jbtn5.getText().equals(jbtn8)&&!jbtn2.getText().equals("")){
            if (jbtn2.getText().equals("o")){
                jlb1.setText("player1 win");
            }else {
                jlb1.setText("player2 win");
            }
        }
        if (jbtn3.getText().equals(jbtn6.getText())&&jbtn6.getText().equals(jbtn9)&&!jbtn3.getText().equals("")){
            if (jbtn3.getText().equals("o")){
                jlb1.setText("player1 win");
            }else {
                jlb1.setText("player2 win");
            }
        }
        if (jbtn4.getText().equals(jbtn5.getText())&&jbtn5.getText().equals(jbtn6)&&!jbtn4.getText().equals("")){
            if (jbtn4.getText().equals("o")){
                jlb1.setText("player1 win");
            }else {
                jlb1.setText("player2 win");
            }
        }
        if (jbtn7.getText().equals(jbtn8.getText())&&jbtn8.getText().equals(jbtn9)&&!jbtn7.getText().equals("")){
            if (jbtn7.getText().equals("o")){
                jlb1.setText("player1 win");
            }else {
                jlb1.setText("player2 win");
            }
        }
        if (jbtn3.getText().equals(jbtn5.getText())&&jbtn5.getText().equals(jbtn7)&&!jbtn3.getText().equals("")){
            if (jbtn3.getText().equals("o")){
                jlb1.setText("player1 win");
            }else {
                jlb1.setText("player2 win");
            }
        }
    }
}
