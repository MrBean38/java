
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentForm extends JFrame implements ActionListener {

    JLabel name, id, dept, gender, address, phone, result;
    JTextField tname, tid, tphone;
    JComboBox<String> tdept;
    JRadioButton male, female;
    JTextArea taddress;
    JButton submit;

    StudentForm() {

        setTitle("Student Form");
        setLayout(new GridLayout(8, 2));

        name = new JLabel("Name:");
        id = new JLabel("Student ID:");
        dept = new JLabel("Department:");
        gender = new JLabel("Gender:");
        address = new JLabel("Address:");
        phone = new JLabel("Phone Number:");

        tname = new JTextField();
        tid = new JTextField();
        tphone = new JTextField();

        String d[] = {"URP", "CSE", "EEE", "CE", "ICE"};
        tdept = new JComboBox<>(d);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);

        taddress = new JTextArea();

        submit = new JButton("Submit");
        result = new JLabel(" ");

        add(name);
        add(tname);

        add(id);
        add(tid);

        add(dept);
        add(tdept);

        add(gender);
        add(genderPanel);

        add(phone);
        add(tphone);

        add(address);
        add(taddress);

        add(submit);
        add(result);

        submit.addActionListener(this);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String n = tname.getText();
        String i = tid.getText();
        String d = (String) tdept.getSelectedItem();
        String p = tphone.getText();
        String a = taddress.getText();

        String g;

        if (male.isSelected())
            g = "Male";
        else if (female.isSelected())
            g = "Female";
        else
            g = "Not selected";

        result.setText("<html>Submitted:<br>Name: " + n
                + "<br>ID: " + i
                + "<br>Department: " + d
                + "<br>Gender: " + g
                + "<br>Phone: " + p
                + "<br>Address: " + a
                + "</html>");
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
