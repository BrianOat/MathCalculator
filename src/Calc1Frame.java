import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Calc1Frame extends JFrame implements ActionListener {
    Scanner scan = new Scanner(System.in);
    JButton Derivative;
    JButton DefIntegration;
    JButton IndefIntegration;
    JButton Calc3;
    public Calc1Frame(){
        Derivative = new JButton("Derivative");
        Derivative.setBounds(1, 1, 250, 250);
        Derivative.addActionListener(this);
        DefIntegration = new JButton("Definite Integration");
        DefIntegration.setBounds(250, 1, 250, 200);
        DefIntegration.addActionListener(this);
        IndefIntegration = new JButton("Indefinite Integration");
        IndefIntegration.setBounds(250, 100, 250, 250);
        IndefIntegration.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(Derivative);
        this.add(DefIntegration);
        this.add(IndefIntegration);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Derivative){
            System.out.println("Enter your function with the appropriate syntax");
            String finalEquation = scan.nextLine();
            System.out.println(MathCalculator.Derive(finalEquation));
        }
        if(e.getSource()==DefIntegration){
            System.out.println("Enter limits of integration: ");
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println("Enter your function with the appropriate syntax");
            scan.nextLine();
            String finalEquation = scan.nextLine();
            System.out.println(MathCalculator.definiteIntegral(a, b, finalEquation));
        }
        if(e.getSource()==IndefIntegration){
            System.out.println("Enter your function with the appropriate syntax");
            String finalEquation = scan.nextLine();
            System.out.println(MathCalculator.indefiniteIntegral(finalEquation) + " + C");
        }
    }
}
