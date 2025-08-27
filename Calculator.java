import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Applet implements ActionListener {
    Label l1, l2, result;
    TextField num1, num2;
    Button Add, Sub, Mult, Div;

    public void init() {
        setLayout(new GridLayout(5, 2, 10, 10));
        setBackground(Color.LIGHT_GRAY);
        l1 = new Label("Enter Number 1:");
        num1 = new TextField(15);

        l2 = new Label("Enter Number 2:");
        num2 = new TextField(15);
        result = new Label("Result will appear here");
        result.setForeground(Color.magenta);
        Add = new Button("ADD");
        Add.setBackground(Color.BLUE);
        Add.setForeground(Color.BLACK);

        Sub = new Button("SUB");
        Sub.setBackground(Color.YELLOW);
        Sub.setForeground(Color.BLACK);

        Mult = new Button("MUL");
        Mult.setBackground(Color.ORANGE);
        Mult.setForeground(Color.BLACK);

        Div = new Button("DIV");
        Div.setBackground(Color.RED);
        Div.setForeground(Color.BLACK);
        add(l1);
        add(num1);
        add(l2);
        add(num2);
        add(new Label("")); 
        add(result);
        add(Add);
        add(Sub);
        add(Mult);
        add(Div);
        Add.addActionListener(this);
        Sub.addActionListener(this);
        Mult.addActionListener(this);
        Div.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            double ans = 0;

            if (e.getSource() == Add) {
                ans = n1 + n2;
            } else if (e.getSource() == Sub) {
                ans = n1 - n2;
            } else if (e.getSource() == Mult) {
                ans = n1 * n2;
            } else if (e.getSource() == Div) {
                if (n2 != 0) {
                    ans = n1 / n2;
                } else {
                    result.setText("Cannot divide by zero");
                    return;
                }
            }

            result.setText("Result: " + ans);
        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Simple Calculator", 80, 50);
    }
}

/* 
<html>
  <body>
    <applet code="Calculator.class" width="350" height="300"></applet>
  </body>
</html>
*/
