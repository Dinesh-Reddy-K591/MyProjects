import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends Applet implements ActionListener {
    TextField t1, t2;
    Label l1, l2;
    Button b1, b2;

    public void init() {
        setBackground(Color.white);
        setFont(new Font("Arial", Font.PLAIN, 16));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        l1 = new Label("Celsius:");
        t1 = new TextField(10);

        l2 = new Label("Fahrenheit:");
        t2 = new TextField(10);

        b1 = new Button("C to F");
        b2 = new Button("F to C");
        b1.setBackground(new Color(245, 200, 66)); 
        b2.setBackground(new Color(144, 238, 144));

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        add(l1, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(t1, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        add(l2, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(t2, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.CENTER;
        add(b1, gbc);
        gbc.gridx = 1;
        add(b2, gbc);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
     public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("TemperatureConverter", 30, 40);
        }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) { 
                double c = Double.parseDouble(t1.getText());
                double f = (c * 9 / 5) + 32;
                t2.setText(String.format("%.2f", f));
            } else if (e.getSource() == b2) { 
                double f = Double.parseDouble(t2.getText());
                double c = (f - 32) * 5 / 9;
                t1.setText(String.format("%.2f", c));
            }
        } catch (Exception ex) {
            showStatus("Enter valid number");
        }
    }
}

/*
<html>
  <body>
    <applet code="TemperatureConverter.class" width="400" height="250"></applet>
  </body>
</html>
*/