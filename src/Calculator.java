import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




class CalcFrame extends JFrame{
    CalcFrame(){
        setBounds(500,500,700,500);
        BorderLayout bl = new BorderLayout();
        GridLayout grl = new GridLayout(4,4);
        setLayout(bl);

        JPanel panel= new JPanel();
        JPanel panelbut = new JPanel();

        panel.setBackground(Color.blue);
        add(panel,bl.NORTH);
        TextArea display = new TextArea();
        JPanel panel1= new JPanel();
        JPanel panel2= new JPanel();
        JPanel panel3= new JPanel();
        panel1.setBackground(Color.yellow);
        panel2.setBackground(Color.red);
        panel3.setBackground(Color.green);
        add(panel1,bl.WEST);
        add(panel2,bl.SOUTH);
        add(panel3,BorderLayout.EAST);

        panelbut.setLayout(grl);
        JButton button = new JButton("1");
        JButton button1 = new JButton("2");
        JButton button2 = new JButton("3");
        JButton button3 = new JButton("4");
        JButton button4 = new JButton("5");
        JButton button5 = new JButton("6");
        JButton button6 = new JButton("7");
        JButton button7 = new JButton("8");
        JButton button8 = new JButton("9");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton equel= new JButton("=");


        new SetListener(button,display);
        new SetListener(button1,display);
        new SetListener(button2,display);
        new SetListener(button3,display);
        new SetListener(button4,display);
        new SetListener(button5,display);
        new SetListener(button6,display);
        new SetListener(button7,display);
        new SetListener(button8,display);
        new calc(div,display);
        new calc(mul,display);
        new calc(plus,display);
        new calc(minus,display);
        new calc(equel,display);
        panelbut.add(button);
        panelbut.add(button1);
        panelbut.add(button2);
        panelbut.add(button3);
        panelbut.add(button4);
        panelbut.add(button5);
        panelbut.add(button6);
        panelbut.add(button7);
        panelbut.add(button8);
        panelbut.add(mul);
        panelbut.add(div);
        panelbut.add(minus);
        panelbut.add(plus);
        panelbut.add(equel);

        add(panelbut,bl.CENTER);

        panel2.add(display);
        setVisible(true);
    }
    /*@Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x,y,width,height);
    }*/
}
public class Calculator {
    public static int oper1=0;
    public static int oper2=0;
    public static int OpFlag=0;
    public static int opop=0;

    public static void main(String[] args) {

    CalcFrame Cf=new CalcFrame();

    }
}
class  SetListener {
    SetListener(JButton button, TextArea display) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Calculator.OpFlag==1) {
                display.setText(button.getText()); Calculator.OpFlag=0;
                            } else {display.setText(display.getText()+button.getText());}}
        });


    }

}
class calc {
    calc(JButton button, TextArea display) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int res=0;
                switch (button.getText()){
                    case "*":
                        Calculator.oper1= Integer.valueOf(display.getText());
                        Calculator.OpFlag=1;
                        display.setText("Multiply");
                        Calculator.opop=1;
                        break;
                    case "/":
                        Calculator.oper1= Integer.valueOf(display.getText());
                        Calculator.OpFlag=1;
                        display.setText("Divide");
                        Calculator.opop=2;
                        break;
                    case "+":
                        Calculator.oper1= Integer.valueOf(display.getText());
                        Calculator.OpFlag=1;
                        Calculator.opop=3;

                        display.setText("Plus");
                        break;
                    case "-":
                        Calculator.oper1= Integer.valueOf(display.getText());
                        Calculator.OpFlag=1;
                        Calculator.opop=4;
                        display.setText("Minus");
                        break;
                    case "=":
                        Calculator.oper2= Integer.valueOf(display.getText());
                        Calculator.OpFlag=0;
                        switch (Calculator.opop) {
                        case 1: res=Calculator.oper2*Calculator.oper1;
                        case 2: res=Calculator.oper1/Calculator.oper2;
                        case 3: res=Calculator.oper1+Calculator.oper2;
                        case 4: res=Calculator.oper1-Calculator.oper2;
                    }

                        Calculator.oper1=res;

                        display.setText(String.valueOf(res));

                        break;
                }
            }
        });
    }
}