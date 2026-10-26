//lab2
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResturantBill extends JFrame implements ActionListener {

    JTextField q1, q2, q3, q4;
    JLabel t1, t2, t3, t4, total;
    JButton bill;

    ResturantBill() {

        setTitle("Restaurant Bill");
        setLayout(new GridLayout(6, 3));

        add(new JLabel("Food"));
        add(new JLabel("Quantity"));
        add(new JLabel("Total"));

        add(new JLabel("Burger (100 Tk)"));
        q1 = new JTextField();
        t1 = new JLabel("0 Tk");
        add(q1);
        add(t1);

        add(new JLabel("Pizza (200 Tk)"));
        q2 = new JTextField();
        t2 = new JLabel("0 Tk");
        add(q2);
        add(t2);

        add(new JLabel("Coffee (80 Tk)"));
        q3 = new JTextField();
        t3 = new JLabel("0 Tk");
        add(q3);
        add(t3);

        add(new JLabel("Chicken (150 Tk)"));
        q4 = new JTextField();
        t4 = new JLabel("0 Tk");
        add(q4);
        add(t4);

        bill = new JButton("Generate Bill");
        total = new JLabel("Total Bill: 0 Tk");

        add(bill);
        add(total);

        bill.addActionListener(this);

        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int burger = Integer.parseInt(q1.getText()) * 100;
        int pizza = Integer.parseInt(q2.getText()) * 200;
        int coffee = Integer.parseInt(q3.getText()) * 80;
        int chicken = Integer.parseInt(q4.getText()) * 150;

        t1.setText(burger + " Tk");
        t2.setText(pizza + " Tk");
        t3.setText(coffee + " Tk");
        t4.setText(chicken + " Tk");

        int bill = burger + pizza + coffee + chicken;

        total.setText("Total Bill: " + bill + " Tk");
    }

    public static void main(String[] args) {
        new ResturantBill();
    }
}