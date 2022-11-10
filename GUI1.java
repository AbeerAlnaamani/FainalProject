import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import static java.lang.Integer.parseInt;

public class GUI1 {
    Management m;
    private JButton adminButton;
    private JButton employeeButton;
    private JPanel allcards;
    private JPanel c1;
    private JPanel c2;
    public JPanel mainB;
    private JButton sempButton;
    private JButton hempButton;

    private JPanel c3;
    private JButton viweButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JPanel c4;
    private JButton addButton;
    private JPanel a1;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JButton addButton1;
    private JButton cleareButton;
    private JPanel v1;
    private JTextArea textArea1;
    private JPanel s1;
    private JButton searchButton1;
    private JTextField textField1;
    private JTextArea textArea2;
    private JPanel d1;
    private JButton deleteButton1;
    private JTextField textField2;
    private JButton ADDButton;
    private JButton viewButton;
    private JButton searchButton2;
    private JButton deleteButton2;
    private JPanel a2;
    private JTextField tt1;
    private JTextField tt6;
    private JTextField tt5;
    private JTextField tt2;
    private JTextField tt4;
    private JTextField tt3;
    private JButton ADDButton1;
    private JPanel v2;
    private JTextArea textArea3;
    private JPanel s2;
    private JTextField textField3;
    private JButton searchButton3;
    private JTextArea textArea4;
    private JPanel d2;
    private JTextField textField4;
    private JButton deleteButton3;

    private JButton ADDButton2;
    private JButton viewButton1;
    private JButton deleteButton5;
    private JPanel a3;
    private JTextField ttt1;
    private JTextField ttt3;
    private JTextField ttt2;
    private JButton addButton2;
    private JPanel v3;
    private JTextArea textArea5;
    private JPanel d3;
    private JTextField textField5;
    private JButton deleteButton4;
    private JPanel log;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton backButton;
    private JButton backButton1;
    private JButton backButton2;
    private JButton backButton3;
    private JButton clearButton;
    private JButton backButton4;
    private JButton backButton5;
    private JButton backButton6;
    private JButton backButton7;
    private JButton backButton8;
    private JButton clearButton2;
    private JButton backButton9;
    private JButton backButton10;
    private JButton button4;
    private JPanel Admin;
    private JTextField Pass;
    private JTextField Name;
    private JButton loginButton;

    public GUI1() throws FileNotFoundException {
        m = new Management();
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(Admin);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c2);
                allcards.repaint();
                allcards.revalidate();
            }
        });

        sempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c3);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allcards.removeAll();
                allcards.add(a1);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(t1.getText());
                int i = parseInt(t1.getText());
                String f = t2.getText();
                String l = t3.getText();
                int t = parseInt(t4.getText());
                double a = Double.parseDouble(t5.getText());
                boolean added = m.addNewEmployees(i, f, l, t, a);
                if (added) {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    try {
                        m.writeEmployeesFile();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                } else JOptionPane.showMessageDialog(null, "Error");

            }
        });
        cleareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                t1.setText(" ");
                t2.setText(" ");
                t3.setText(" ");
                t4.setText(" ");
                t5.setText(" ");

            }
        });
        viweButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(v1);
                allcards.repaint();
                allcards.revalidate();
                String s = " ID\tFiRstName\tLastName\tphoneNumber\tSalary\n";
                SalariedEmployee[] allEmployees = m.viewAllEmployees();
                for (SalariedEmployee se : allEmployees) {
                    if (se != null)
                        s = s + se.toString();
                }
                textArea1.setText(s);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(s1);
                allcards.repaint();
                allcards.revalidate();

            }
        });
        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalariedEmployee se1 = m.searchForEmployees(parseInt(textField1.getText()));


                String s = " ID FiRstName\t LastName\t PhoneNumber\t Salary\n";
                if (se1 != null)
                    textArea2.setText(se1.toString());
                SalariedEmployee[] allEmployees = m.viewAllEmployees();
                for (SalariedEmployee se : allEmployees) {
                    if (se != null)
                        s = s + se.toString();
                }


            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(d1);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = parseInt(textField2.getText());
                SalariedEmployee se = m.searchForEmployees(i);
                if (se != null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "do you want to delete the following employee\n");
                    if (confirm == 0) {
                        boolean delete = m.deleteEmployees(i);
                        if (delete) JOptionPane.showMessageDialog(null, "delete Successfully");

                        else JOptionPane.showMessageDialog(null, "error");
                        textField1.setText("");
                    }
                }
            }
        });
        hempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c4);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        ADDButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(t1.getText());
                int i = parseInt(tt1.getText());
                String f = tt2.getText();
                String l = tt3.getText();
                int t = parseInt(tt4.getText());
                double n = Double.parseDouble(tt5.getText());
                double p = Double.parseDouble(tt6.getText());
                boolean added = m.addNewEmployeesH(i, f, l, t, n, p);
                if (added) {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    tt1.setText("");
                    tt2.setText("");
                    tt3.setText("");
                    tt4.setText("");
                    tt5.setText("");
                    tt6.setText("");
                    try {
                        m.writeEmployeesHFile();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                } else JOptionPane.showMessageDialog(null, "Error");
            }

        });
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(a2);
                allcards.repaint();
                allcards.revalidate();

            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(v2);
                allcards.repaint();
                allcards.revalidate();
                String s = " ID\tFiRstName\tLastName\tPhoneNumber\tnumber of hour\tprice\n";
                HourlyEmployee[] allEmployeesH = m.viewAllEmployeesH();
                for (HourlyEmployee se : allEmployeesH) {
                    if (se != null)
                        s = s + se.toString();
                }
                textArea3.setText(s);
            }


        });
        searchButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(s2);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        searchButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HourlyEmployee se1 = m.searchForEmployeesH(parseInt(textField3.getText()));

                String s = " ID FiRstName\t LastName\t PhoneNumber\t number of hour\n price\n";
                if (se1 != null)
                    textArea4.setText(se1.toString());
                HourlyEmployee[] allEmployeesH = m.viewAllEmployeesH();
                for (HourlyEmployee se : allEmployeesH) {
                    if (se != null)
                        s = s + se.toString();
                }
            }
        });
        deleteButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(d2);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        deleteButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = parseInt(textField4.getText());
                HourlyEmployee se = m.searchForEmployeesH(i);
                if (se != null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "do you want to delete the following employee\n");
                    if (confirm == 0) {
                        boolean delete = m.deleteEmployeesH(i);
                        if (delete) JOptionPane.showMessageDialog(null, "delete Successfully");

                        else JOptionPane.showMessageDialog(null, "error");
                        textField4.setText("");
                    }
                }
            }
        });
        ADDButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(a3);
                allcards.repaint();
                allcards.revalidate();

            }
        });
        addButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(ttt1.getText());
                int i = parseInt(ttt1.getText());
                String f = ttt2.getText();
                double p = Double.parseDouble(ttt3.getText());
                boolean added = m.addflavor(i, f, p);
                if (added) {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    ttt1.setText("");
                    ttt2.setText("");
                    ttt3.setText("");
                    t4.setText("");
                    t5.setText("");
                    try {
                        m.writeflavorFile();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                } else JOptionPane.showMessageDialog(null, "Error");


            }
        });
        viewButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(v3);
                allcards.repaint();
                allcards.revalidate();
                String s = " ID\tproducts\t\tprice\n";
                FlavorAndPrice[] alllavorss = m.viewAllflavor();
                for (FlavorAndPrice se : alllavorss) {
                    if (se != null)
                        s = s + se.toString();
                }
                textArea5.setText(s);

            }
        });
        deleteButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(d3);
                allcards.repaint();
                allcards.revalidate();

            }
        });
        deleteButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = parseInt(textField5.getText());
                FlavorAndPrice se = m.searchForflavor(i);
                if (se != null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "do you want to delete the following Producer\n");
                    if (confirm == 0) {
                        boolean delete = m.deleteflavor(i);
                        if (delete) JOptionPane.showMessageDialog(null, "delete Successfully");

                        else JOptionPane.showMessageDialog(null, "error");
                        textField1.setText("");
                    }

                }}
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c1);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c1);
                allcards.repaint();
                allcards.revalidate();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(log);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c3);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c3);
                allcards.repaint();
                allcards.revalidate();
                textArea1.setText("");
            }
        });
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c3);
                allcards.repaint();
                allcards.revalidate();
                textArea2.setText("");
                textField1.setText("");
            }
        });

        backButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c3);
                allcards.repaint();
                allcards.revalidate();
                textField2.setText("");
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tt1.setText(" ");
                tt6.setText(" ");
                tt5.setText(" ");
                tt2.setText(" ");
                tt4.setText(" ");
                tt3.setText(" ");
            }
        });
        backButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c4);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        backButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(log);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        backButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c4);
                allcards.repaint();
                allcards.revalidate();
                textArea3.setText("");
            }
        });
        backButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c4);
                allcards.repaint();
                allcards.revalidate();
                textArea4.setText("");
            }
        });
        backButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c4);
                allcards.repaint();
                allcards.revalidate();
                textField4.setText("");
            }
        });
        clearButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttt1.setText("");
                ttt2.setText("");
                ttt3.setText("");
            }
        });
        backButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c2);
                allcards.repaint();
                allcards.revalidate();
            }
        });
        backButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c2);
                allcards.repaint();
                allcards.revalidate();
                textArea5.setText("");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allcards.removeAll();
                allcards.add(c2);
                allcards.repaint();
                allcards.revalidate();
                textField5.setText("");
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name =Name.getText();
                String pass =Pass.getText();
                if(!name.equals(m.name)||!pass.equals(m.pass))
                    JOptionPane.showMessageDialog(null,"You are not Management");
                else
                allcards.removeAll();
                allcards.add(log);
                allcards.repaint();
                allcards.revalidate();
            }
        });
    }


    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("GUI1");
        frame.setContentPane(new GUI1().mainB);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
    }


}
