import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numeros = new JButton[10];
	JButton[] botoesFuncao = new JButton[9];
	JButton adicao, subtracao, multiplicacao, divisao;
	JButton decimal, igual, delete, clear, negativo;
	JPanel panel;
	
	double num1=0,num2=0,resultado=0;
	char operador;
	
	Calculadora(){
		
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setEditable(false);
		
		adicao = new JButton("+");
		subtracao = new JButton("-");
		multiplicacao = new JButton("*");
		divisao = new JButton("/");
		decimal = new JButton(".");
		igual = new JButton("=");
		delete = new JButton("Del");
		clear = new JButton("C");
		negativo = new JButton("(-)");
		
		botoesFuncao[0] = adicao;
		botoesFuncao[1] = subtracao;
		botoesFuncao[2] = multiplicacao;
		botoesFuncao[3] = divisao;
		botoesFuncao[4] = decimal;
		botoesFuncao[5] = igual;
		botoesFuncao[6] = delete;
		botoesFuncao[7] = clear;
		botoesFuncao[8] = negativo;
		
		for(int i =0;i<9;i++) {
			botoesFuncao[i].addActionListener(this);
			botoesFuncao[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numeros[i] = new JButton(String.valueOf(i));
			numeros[i].addActionListener(this);
			numeros[i].setFocusable(false);
		}
		
		negativo.setBounds(50,430,100,50);
		delete.setBounds(150,430,100,50);
		clear.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numeros[1]);
		panel.add(numeros[2]);
		panel.add(numeros[3]);
		panel.add(adicao);
		panel.add(numeros[4]);
		panel.add(numeros[5]);
		panel.add(numeros[6]);
		panel.add(subtracao);
		panel.add(numeros[7]);
		panel.add(numeros[8]);
		panel.add(numeros[9]);
		panel.add(multiplicacao);
		panel.add(decimal);
		panel.add(numeros[0]);
		panel.add(igual);
		panel.add(divisao);
		
		frame.add(panel);
		frame.add(clear);
		frame.add(textfield);
		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numeros[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decimal) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==adicao) {
			num1 = Double.parseDouble(textfield.getText());
			operador ='+';
			textfield.setText("");
		}
		if(e.getSource()==subtracao) {
			num1 = Double.parseDouble(textfield.getText());
			operador ='-';
			textfield.setText("");
		}
		if(e.getSource()==multiplicacao) {
			num1 = Double.parseDouble(textfield.getText());
			operador ='*';
			textfield.setText("");
		}
		if(e.getSource()==divisao) {
			num1 = Double.parseDouble(textfield.getText());
			operador ='/';
			textfield.setText("");
		}
		if(e.getSource()==igual) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operador) {
			case'+':
				resultado=num1+num2;
				break;
			case'-':
				resultado=num1-num2;
				break;
			case'*':
				resultado=num1*num2;
				break;
			case'/':
				resultado=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(resultado));
			num1=resultado;
		}
		if(e.getSource()==clear) {
			textfield.setText("");
		}
	}
}