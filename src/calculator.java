import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class calculator implements ActionListener{
    JFrame f;
    JTextField t;
    JPanel p;
    
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];

    JButton bAdd, bSub, bMulti, bDiv, bDot, bEquals, bClear;

    double num1=0, num2=0, result=0;
    char operator;
    
    calculator(){
        f = new JFrame("Simple Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(420, 550);
        f.setLayout(null);

        t = new JTextField();
        t.setBounds(50,25,300,50);
        t.setEditable(false);

        bAdd = new JButton("+");
        bSub = new JButton("-");
        bMulti = new JButton("*");
        bDiv = new JButton("/");
        bDot = new JButton(".");
        bEquals = new JButton("=");
        bClear = new JButton("C");

        funcButtons[0] = bAdd;
        funcButtons[1] = bSub;
        funcButtons[2] = bMulti;
        funcButtons[3] = bDiv;
        funcButtons[4] = bDot;
        funcButtons[5] = bEquals;
        funcButtons[6] = bClear;

        for(int i=0; i<6; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
        }

        bClear.setBounds(150,430,100,50);

        p = new JPanel();
        p.setBounds(50,100,300,300);
        p.setLayout(new GridLayout(4,4,10,10));

        p.add(numButtons[7]);
        p.add(numButtons[8]);
        p.add(numButtons[9]);
        p.add(funcButtons[3]);

        p.add(numButtons[4]);
        p.add(numButtons[5]);
        p.add(numButtons[6]);
        p.add(funcButtons[2]);

        p.add(numButtons[1]);
        p.add(numButtons[2]);
        p.add(numButtons[3]);
        p.add(funcButtons[1]);

        p.add(funcButtons[4]);
        p.add(numButtons[0]);
        p.add(funcButtons[5]);
        p.add(funcButtons[0]);

        f.add(p);
        f.add(t);
        f.add(bClear);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        calculator calc = new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10; i++){
            if(e.getSource() == numButtons[i]){
                t.setText(t.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == bDot){
            t.setText(t.getText().concat("."));
        }
        if(e.getSource()==bAdd){
            num1 = Double.parseDouble(t.getText());
            operator = '+';
            t.setText("");
        }
        if(e.getSource()==bSub){
            num1 = Double.parseDouble(t.getText());
            operator = '-';
            t.setText("");
        }
        if(e.getSource()==bMulti){
            num1 = Double.parseDouble(t.getText());
            operator = '*';
            t.setText("");
        }
        if(e.getSource()==bDiv){
            num1 = Double.parseDouble(t.getText());
            operator = '/';
            t.setText("");
        }
        if(e.getSource()==bEquals){
            num2 = Double.parseDouble(t.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            t.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == bClear){
            t.setText("");
        }
    }
}