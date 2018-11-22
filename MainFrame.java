import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    Container cp;
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmT = new JMenu("Tool");
    private JMenu jmG = new JMenu("Game");
    private JMenu jmH = new JMenu("Help");
    private JMenuItem jmiOpen = new JMenuItem("OPEN");
    private JMenuItem jmiClose = new JMenuItem("CLOSE");
    private JMenuItem jmiExit = new JMenuItem("EXIT");
    private JMenuItem jmiOX = new JMenuItem("OX");
    private JMenuItem jmiD = new JMenuItem("Decrypt");
    private JMenuItem jmiEF = new JMenuItem("EncryptFile");





    public MainFrame(){
        ex1();
    }

    private void ex1() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 500);
        cp = this.getContentPane();
       this.setJMenuBar(jmb);
       jmb.add(jmF);
       jmb.add(jmT);
       jmb.add(jmG);
       jmb.add(jmH);
       jmF.add(jmiOpen);
       jmF.add(jmiClose);
       jmF.add(jmiExit);
       jmG.add(jmiOX);
       jmT.add(jmiD);
       jmT.add(jmiEF);

           jmiExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);

                }
            });

            jmiOX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ox OXG = new ox( MainFrame.this);
                    OXG.setVisible(true);
                }
            });

        jmiD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Decrypt DE = new Decrypt( MainFrame.this);
                DE.setVisible(true);
            }
        });

        jmiEF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncryptFile EF = new EncryptFile( MainFrame.this);
                EF.setVisible(true);
            }
        });


        }

    }
