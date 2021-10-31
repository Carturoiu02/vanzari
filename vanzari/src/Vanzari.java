import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;


public class Vanzari {
    private JPanel Main;
    private JButton ratebtn;
    private JButton stergebtn;
    private JButton cumparabtn;
    private JTextField marcatxt;
    private JTextField modeltxt;
    private JTextField versiunetxt;
    private JTextField prettxt;
    private JComboBox sistemlst;
    private JComboBox marcalst;
    private JComboBox modellst;
    private JComboBox versiunelst;
    private ArrayList<Produs> produse;


    public Vanzari() {
        produse = new ArrayList<Produs>();
        produse.add(0, new Produs("Senzori sistem franare", "OPEL", "Astra J Sport Tourer", "1.7 CDTI (85 KW/ 110 CP (10.2010 - 10.2015)", 7900));
        produse.add(1, new Produs("Senzori parcare", "Samsung", "Galaxy S21 Ultra", "128GB", 6000));
        produse.add(2, new Produs("Cablaje pentru oglinzi", "Huawei", "P50 PRO", "256GB", 6500));
        produse.add(3, new Produs("Cutii de viteze automate", "Huawei", "P50 PRO", "256GB", 6500));
        sistemlst.setSelectedItem(null);

        stergebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Ești sigur că vrei să ștergi toate datele introduse?" , "Question",
                        JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION){
                    marcatxt.setText("");
                    modeltxt.setText("");
                    versiunetxt.setText("");
                    prettxt.setText("");

                    JLabel label = new JLabel("Datele au fost șterse!");
                    JOptionPane.showMessageDialog(null, label, "Atenție", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JLabel label = new JLabel("Datele NU au fost șterse!");
                    JOptionPane.showMessageDialog(null, label, "Atenție", JOptionPane.INFORMATION_MESSAGE);
                }

                System.out.println(result);
            }
        });

        ratebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pret = produse.get(sistemlst.getSelectedIndex()).getPret();
                int dobanda = 18;
                int nr_rate = 24;

                JLabel label = new JLabel("<html>Rată lunară (24 rate): " + String.format("%.2f", (1 + (double)dobanda / 100) * pret / nr_rate) + " lei <br> Preț total: " + String.format("%.2f", (1 + (double)dobanda / 100) * pret) + " lei <br> Dobânda: " + dobanda + "%");
                JOptionPane.showMessageDialog(null, label, "Rata lunara", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cumparabtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel("<html>Felicitari ! <br> Ai achizitionat "
                        + produse.get(sistemlst.getSelectedIndex()).getMarca() + " "
                        + produse.get(sistemlst.getSelectedIndex()).getModel() + " "+"!");
                JOptionPane.showMessageDialog(null, label, "Achizitionat", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        sistemlst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcatxt.setText(produse.get(sistemlst.getSelectedIndex()).getMarca());
                modeltxt.setText(produse.get(sistemlst.getSelectedIndex()).getModel());
                versiunetxt.setText(produse.get(sistemlst.getSelectedIndex()).getVersiune());
                prettxt.setText(Integer.toString(produse.get(sistemlst.getSelectedIndex()).getPret())+" RON");
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Site Telefoane");
        frame.setContentPane(new Vanzari().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 450);
        frame.getContentPane().setBackground(new Color(0, 250, 154));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }
}