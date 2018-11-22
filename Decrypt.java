import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Decrypt extends JFrame {
    Container cp;
    private JTextArea jtaR = new JTextArea("", 30, 15);
    private JTextArea jtaL = new JTextArea("", 30, 15);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JPanel jpnC = new JPanel(new GridLayout(9, 1, 5, 5));
    private JPanel jpnR = new JPanel(new GridLayout(1, 1, 5, 5));
    private JPanel jpnL = new JPanel(new GridLayout(1, 1, 5, 5));
    private JLabel jlb = new JLabel("Method");
    private String methodStr[] = {"DES", "AES", "Caesar", "XOR"};
    private JComboBox jcb = new JComboBox<String>(methodStr);
    private JLabel jlbpw = new JLabel("PassWord");
    private JTextField jtfkey = new JTextField();
    private JRadioButton jrbEncypt = new JRadioButton("Encypt");
    private JRadioButton jrbDecypt = new JRadioButton("Decypt");
    private JButton jbtRN = new JButton("RUN");
    private JButton jbtCL = new JButton("Close");
    private ButtonGroup buttonGroup = new ButtonGroup();

    private JMenuBar jmb = new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenu jma = new JMenu("About");
    private JMenuItem jmiopen = new JMenuItem("Open");
    private JMenuItem jmiclose = new JMenuItem("Close");
    private JMenuItem jmisave = new JMenuItem("Save");
    private JFileChooser jfc = new JFileChooser();

    MainFrame frm5;

    public Decrypt(MainFrame frm6) {
        frm5 = frm6;
        ex1();
    }

    private void ex1() {
        this.setBounds(100, 100, 560, 400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm5.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpnL, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnR, BorderLayout.EAST);
        jpnL.add(jspL);
        jpnR.add(jspR);
        jpnC.add(jlb);
        jpnC.add(jcb);
        jpnC.add(jlbpw);
        jpnC.add(jtfkey);
        jpnC.add(jrbEncypt);
        jpnC.add(jrbDecypt);
        jpnC.add(jbtRN);
        jpnC.add(jbtCL);
        buttonGroup.add(jrbEncypt);
        buttonGroup.add(jrbDecypt);

        this.setJMenuBar(jmb);
        jmb.add(jmf);
        jmb.add(jma);
        jmf.add(jmiopen);
        jmf.add(jmiclose);
        jmf.add(jmisave);

        jbtRN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbEncypt.isSelected()) {
                    int dataLength = jtaL.getText().length();
                    if (dataLength > 0) {
                        switch (jcb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    char data[] = jtaL.getText().toCharArray();
                                    int key = Integer.parseInt(jtfkey.getText());
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }
                                    jtaR.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "key is not Number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "Error" + exp1.toString());
                                }
                                break;
                            case 3:
                                char data[] = jtaL.getText().toCharArray();
                                char key[] = jtfkey.getText().toCharArray();
                                for (int i = 0; i < data.length; i++) {
                                    data[i] = (char) ((int) (data[i] ^ (int) key[i % key.length]));
                                }
                                jtaR.setText(new String(data));
                                break;
                        }
                    }
                } else if (jrbDecypt.isSelected()) {
                    int dataLength = jtaR.getText().length();
                    if (dataLength > 0) {
                        switch (jcb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    char data[] = jtaR.getText().toCharArray();
                                    int key = Integer.parseInt(jtfkey.getText());
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] - key);
                                    }
                                    jtaL.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "key is not Number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "Error" + exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                        }
                    }
                }
            }
        });
        jmiopen.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jfc.showOpenDialog(Decrypt.this) == JFileChooser.APPROVE_OPTION) {
                        jtaL.setText("");
                        String str = "";
                        File selectFile = jfc.getSelectedFile();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfr = new BufferedReader(fr);
                        while ((str = bfr.readLine()) != null) {
                            jtaL.append(str);
                        }
                        fr.close();
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(Decrypt.this, "Open file error: "
                            + ioe.toString());
                }
            }
        });
        jmisave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jtaR.getText().length() > 0) {
                        jfc.setFileFilter(new FileNameExtensionFilter(".txt.doc", "txt", "doc"));
                        if (jfc.showOpenDialog(Decrypt.this) == JFileChooser.APPROVE_OPTION) {
                            jtaL.setText("");
                            String str = "";
                            File selectFile = new File(jfc.getSelectedFile().getPath() + jfc.getSelectedFile().getName() + ".txt");
                            FileWriter fw = new FileWriter(selectFile);
                            BufferedWriter bfw = new BufferedWriter(fw);
                            bfw.write(jtaR.getText());
                            bfw.close();
                        }
                    } else {
                        JOptionPane.showMessageDialog(Decrypt.this, "NO DATA CAN WRITE OUT");
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(Decrypt.this, "Open file error: "
                            + ioe.toString());
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(Decrypt.this, "Error:" + ee.toString());
                }
            }
        });


        jbtCL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame frm2 = new MainFrame();
                frm2.setVisible(true);
                Decrypt.this.dispose();
            }
        });
    }
}