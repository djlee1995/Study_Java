import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;

public class GUI_Calcul {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListener listener = new Calculator(null, null);
		JFrame frame = new JFrame("계산기 프로그램");
		frame.setPreferredSize(new Dimension(300, 500));// 크기조정
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(200,40));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(5,3));
		JButton btn[] = new JButton[17];
	
		btn[0]=new JButton("0");
		btn[1] =new JButton("1");
		btn[2] =new JButton("2");
		btn[3] =new JButton("3");
		btn[4] =new JButton("4");
		btn[5] =new JButton("5");
		btn[6] =new JButton("6");
		btn[7] =new JButton("7");
		btn[8] =new JButton("8");
		btn[9] =new JButton("9");
		btn[10] =new JButton("+");
		btn[11] =new JButton("-");
		btn[12] =new JButton("*");
		btn[13] =new JButton("/");
		btn[14] =new JButton("=");
		btn[15] =new JButton("Clear");
		btn[15].setPreferredSize(new Dimension(190,70));
		btn[16] =new JButton("Back");
		btn[16].setPreferredSize(new Dimension(100,70));
		JPanel panel2= new JPanel(new BorderLayout());
		panel2.add(btn[15],BorderLayout.WEST);
		panel2.add(btn[16],BorderLayout.CENTER);
		
		for(int i=0;i<btn.length-2;i++) {
			panel1.add(btn[i]);
		}
		contentPane.add(text,BorderLayout.NORTH);
		contentPane.add(panel1,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		for(int i=0; i<btn.length; i++) {
			btn[i].addActionListener(new Calculator(text, btn));
		}
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
