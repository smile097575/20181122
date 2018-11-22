import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swimming extends JFrame {
    private MainFrame mfr;
    private Container cp;

    class Fish extends JLabel implements Runnable {
        private int frmW, frmH, x, y, r1, r;
        private ImageIcon[][] imageIcon = {};
        private boolean dirFlag = true;
        private Timer t1;
        private Random rd = new Random();

        public Fish(int frmH, int frmW) {
            this.frmH = frmH;
            this.frmW = frmW;
            x = rd.nextInt(frmW - 100);
            y = rd.nextInt(frmH - 100);
            r = rd.nextInt(2);
            if (r == 1) {
                this.dirFlag = false;
            }
            this.setIcon(imageIcon[r][r1 = rd.nextInt(5)]);
            this.setBounds(x, y, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
        }

        @Override
        public void run() {
            t1 = new Timer(rd.nextInt(1000) + 50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Fish.this.dirFlag) {
                        if ((x - 10) > 0) {
                            x -= 10;
                        } else {
                            Fish.this.dirFlag = !Fish.this.dirFlag;
                            r = 1;
                            Fish.this.setIcon(imageIcon[r][r1]);
                            x += 10;
                        }
                    }

                }

            });
        }
    }

}


