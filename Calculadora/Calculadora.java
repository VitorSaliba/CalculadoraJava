import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener{
   static JTextField t = new JTextField(15);
   static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, p1, mn, m1, dv, c, i;
   String primeiroNum, segundoNum, op="";
   double res;
   int aft = 0;

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        JFrame f = new JFrame("Calculadora");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        p1 = new JButton("+");
        mn = new JButton("-");
        m1 = new JButton("*");
        dv = new JButton("/");
        c = new JButton("C");
        i = new JButton("=");

        JPanel p = new JPanel();
        p.add(t);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b0);
        p.add(p1);
        p.add(mn);
        p.add(m1);
        p.add(dv);
        p.add(i);
        p.add(c);

        f.add(p);
        f.setSize(205,210);
        f.show(true);

        b1.addActionListener(calc);
        b2.addActionListener(calc);
        b3.addActionListener(calc);
        b4.addActionListener(calc);
        b5.addActionListener(calc);
        b6.addActionListener(calc);
        b7.addActionListener(calc);
        b8.addActionListener(calc);
        b9.addActionListener(calc);
        b0.addActionListener(calc);
        p1.addActionListener(calc);
        mn.addActionListener(calc);
        m1.addActionListener(calc);
        dv.addActionListener(calc);
        i.addActionListener(calc);
        c.addActionListener(calc);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();

        if(s.charAt(0) >= '0' && s.charAt(0) <= 9 && aft == 0){
            primeiroNum = t.getText()+s;
            t.setText(primeiroNum);
        }
        else if(s.charAt(0) >= '0' && s.charAt(0) <= 9 && aft == 1){
            segundoNum = t.getText()+s;
            t.setText(segundoNum);
        }
        else if(s.charAt(0) == '+'){
            t.setText("");
            op="+";
            aft=1;
        }
        else if(s.charAt(0) == '-'){
            t.setText("");
            op="-";
            aft=1;
        }
        else if(s.charAt(0) == '*'){
            t.setText("");
            op="*";
            aft=1;
        }
        else if(s.charAt(0) == '/'){
            t.setText("");
            op="/";
            aft=1;
        }
        else if(s.charAt(0) == 'C'){
            t.setText("");
        }
        else if(s.charAt(0) == '='){
            if(op.charAt(0) == '+'){
                res = Double.parseDouble(primeiroNum) + Double.parseDouble(segundoNum);
                t.setText(Double.toString(res));
                primeiroNum=Double.toString(res);
            }
            if(op.charAt(0) == '-'){
                res = Double.parseDouble(primeiroNum) - Double.parseDouble(segundoNum);
                t.setText(Double.toString(res));
                primeiroNum=Double.toString(res);
            }
            if(op.charAt(0) == '*'){
                res = Double.parseDouble(primeiroNum) * Double.parseDouble(segundoNum);
                t.setText(Double.toString(res));
                primeiroNum=Double.toString(res);
            }
            if(op.charAt(0) == '/'){
                res = Double.parseDouble(primeiroNum) / Double.parseDouble(segundoNum);
                t.setText(Double.toString(res));
                primeiroNum=Double.toString(res);
            }
        }
    }
}

