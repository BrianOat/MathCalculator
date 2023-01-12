import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {
    JButton Calc2;
    JButton Calc1;
    JButton Calc3;
    public CalculatorFrame(){
        Calc2 = new JButton("Calculus2");
        Calc2.setBounds(1, 1, 250, 250);
        Calc2.addActionListener(this);
        Calc1 = new JButton("Calculus1");
        Calc1.setBounds(250, 1, 250, 250);
        Calc1.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(Calc2);
        this.add(Calc1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Calc2){
            System.out.println("Work in Progress");
        }
        if(e.getSource()==Calc1){
            new Calc1Frame();
        }
    }
}
