import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class EncryptFile extends JFrame {
    public static void main(String[] args) {

    }

    private Container cp;
    private JPanel jpnW = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jpnE = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jpnC = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jpnN = new JPanel(new GridLayout(1, 6, 3, 3));
    private JPanel jpnS = new JPanel(new GridLayout(1, 1, 0, 0));
    private JLabel jlb1 = new JLabel("原始檔");
    private JLabel jlb2 = new JLabel("加密檔");
    private JLabel jlb3 = new JLabel("加密法");
    private JLabel jlbkey = new JLabel("key");
    private String methodStr[] = {"Caesar", "XOR", "DES", "AES"};
    private JComboBox jcomb = new JComboBox(methodStr);
    private JFileChooser jfc = new JFileChooser();
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JTextField jtfkey = new JTextField(" ");
    private JButton jbtnload = new JButton("Choose");
    private JButton jbtnsave = new JButton("Choose");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("Close");
    private JProgressBar jpb = new JProgressBar();
    private int frmw = 400, frmh = 200;
    private MainFrame frm7;

    public EncryptFile(MainFrame lo) {
        this.frm7 = lo;
        e();
    }

    public void e() {
        this.setBounds(100, 100, frmw, frmh);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frm7.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpnN, BorderLayout.NORTH);
        cp.add(jpnW, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnE, BorderLayout.EAST);
        cp.add(jpnS, BorderLayout.SOUTH);

        jpnN.add(jlb3);
        jpnN.add(jcomb);
        jpnN.add(jlbkey);
        jpnN.add(jtfkey);
        jpnN.add(jbtnrun);
        jpnN.add(jbtnclose);
        jpnW.add(jlb1);
        jpnW.add(jlb2);
        jpnC.add(jtf1);
        jpnC.add(jtf2);
        jpnE.add(jbtnsave);
        jpnE.add(jbtnload);
        jpnS.add(jpb);

        jbtnrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf1.getText().equals("")){
                    JOptionPane.showMessageDialog(EncryptFile.this,"no file selected");
                }else {
                    try{
                        File selectFile = new File(jtf1.getText());
                        long fileLength = selectFile.length();
                        jpb.setMaximum(100);
                        char key[] = jtfkey.getText().toCharArray();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfr = new BufferedReader(fr);
                        File writerFile = new File(jtf2.getText());
                        FileWriter fw = new FileWriter(writerFile);
                        BufferedWriter bfw = new BufferedWriter(fw);
                        int data;
                        int i = 0;
                        while ((data=bfr.read())!=-1){
                            data = data^key[i%key.length];
                            bfw.write(data);
                            i++;
                            jpb.setValue(Math.round((float)i/fileLength*100));
                        }
                        bfw.close();
                        fr.close();
                        JOptionPane.showMessageDialog(EncryptFile.this,"Finish!");
                    }catch (IOException ioe){
                        JOptionPane.showMessageDialog(EncryptFile.this,"open file erroe" + ioe.toString());
                    }
                }
            }
        });
        jbtnload.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf1.setText(jfc.getSelectedFile().getPath());
                jtf2.setText(jtf1.getText()+".sec");
            }
        });

    }
}