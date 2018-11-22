import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalTimer extends JFrame {
    Container cp;
    private MainFrame mfr;
    private JLabel jlbs[] = new JLabel[8];
    private JPanel jpnC = new JPanel(new GridLayout(1, 8, 2, 2));
    private String jlbImageName[] = {"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png"};
    private ImageIcon icons[] = new ImageIcon[10];
    private JPanel jpnS = new JPanel(new GridLayout(1, 3, 3, 3));
    private JButton jbtnstart = new JButton("Start");
    private JButton jbtnreset = new JButton("Reset");
    private JButton jbtnclose = new JButton("Close");
    private Timer t1;
    private int h, m, s;

    public DigitalTimer(MainFrame frm) {
        mfr = frm;
        ex2();
    }

    private void ex2() {
        this.setBounds(100, 100, 300, 150);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));

        for (int i = 0; i < 10; i++) {
            icons[i] = new ImageIcon(jlbImageName[i]);
            Image img = icons[i].getImage();
            Image newimg = img.getScaledInstance(30, 60, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(newimg);
        }
        jlbs[6] = new JLabel(":");
        jlbs[6].setFont(new Font(null, Font.BOLD, 24));
        jlbs[6].setHorizontalAlignment(JLabel.CENTER);
        jlbs[7] = new JLabel(":");
        jlbs[7].setFont(new Font(null, Font.BOLD, 24));
        jlbs[7].setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 6; i++) {
            jlbs[i] = new JLabel((icons)[0]);
            if (i == 2) {
                jpnC.add(jlbs[6]);
                jpnC.add(jlbs[i]);
            } else {
                jpnC.add(jlbs[i]);
            }
        }
        t1 = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s++;
                if (s == 60) {
                    s = 0;
                    m++;
                    if (m == 60) {
                        m = 0;
                        h++;
                    }
                }
                if (s % 2 == 0) {
                    jlbs[6].setForeground(Color.GREEN);
                    jlbs[7].setForeground(Color.GREEN);
                } else {
                    jlbs[6].setForeground(Color.BLACK);
                    jlbs[7].setForeground(Color.BLACK);
                }
                jlbs[5].setIcon(icons[s % 10]);
                jlbs[4].setIcon(icons[s / 2]);
                jlbs[3].setIcon(icons[m % 10]);
                jlbs[2].setIcon(icons[m / 2]);
                jlbs[1].setIcon(icons[h % 10]);
                jlbs[0].setIcon(icons[h / 2]);
            }
        });
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnS,BorderLayout.SOUTH);
        jpnS.add(jbtnstart);
        jpnS.add(jbtnreset);
        jpnS.add(jbtnclose);

        jbtnstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpbtn = (JButton)e.getSource();
                if (tmpbtn.getText().equals("start")){
                    t1.start();
                    tmpbtn.setText("Pause");
                }else{
                    t1.stop();
                    tmpbtn.setText("Start");
                }
            }
        });
    }
}
