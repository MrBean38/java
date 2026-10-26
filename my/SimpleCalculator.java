//lab 4
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField display;

    SimpleCalculator() {

        setTitle("Calculator");
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 25));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String buttons[] = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String s : buttons) {

            JButton b = new JButton(s);
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.addActionListener(this);
            panel.add(b);
        }

        add(panel, BorderLayout.CENTER);

        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();

        // Number button
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {

            display.setText(display.getText() + s);
        }

        // Operator button
        else if (s.equals("+") || s.equals("-")
                || s.equals("*") || s.equals("/")) {

            display.setText(display.getText() + " " + s + " ");
        }

        // Clear button
        else if (s.equals("C")) {

            display.setText("");
        }

        // Equal button
        else if (s.equals("=")) {

            try {

                String expression = display.getText();

                double result = calculate(expression);

                display.setText(String.valueOf(result));

            } catch (Exception ex) {

                display.setText("Error");
            }
        }
    }

    // Calculate the complete expression
    double calculate(String expression) {

        String parts[] = expression.trim().split(" ");

        double result = Double.parseDouble(parts[0]);

        for (int i = 1; i < parts.length; i += 2) {

            String operator = parts[i];
            double number = Double.parseDouble(parts[i + 1]);

            if (operator.equals("+"))
                result = result + number;

            else if (operator.equals("-"))
                result = result - number;

            else if (operator.equals("*"))
                result = result * number;

            else if (operator.equals("/"))
                result = result / number;
        }

        return result;
    }

    public static void main(String[] args) {

        new SimpleCalculator();
    }
}
