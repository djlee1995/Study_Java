package Teacher;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUI_Sungjuk {
	public static void main(String[] args) {
		JFrame frame = new JFrame("성적 프로그램");
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setLocation(500, 400);
		Container contenPane = frame.getContentPane();
		String colNames[] = { "학번", "이름", "국어", "영어", "수학", "총점", "평균", "등급" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		int width[]= {70,70,50,50,50,50,50,50};
		for (int i=0;i<width.length; i++) {
			TableColumn colum = table.getColumnModel().getColumn(i);
			colum.setPreferredWidth(width[i]);
		}
		
	
		contenPane.add(new JScrollPane(table), BorderLayout.CENTER);
		

		JTextField txtHakbun = new JTextField(5);
		JTextField txtIrum = new JTextField(5);
		JTextField txtKor = new JTextField(3);
		JTextField txtEng = new JTextField(3);
		JTextField txtMath = new JTextField(3);
		
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		JButton button3 = new JButton("수정");
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("학번"));
		panel.add(txtHakbun);
		panel.add(new JLabel("이름"));
		panel.add(txtIrum);
		panel.add(new JLabel("국어"));
		panel.add(txtKor);
		panel.add(new JLabel("영어"));
		panel.add(txtEng);
		panel.add(new JLabel("수학"));
		panel.add(txtMath);
		JPanel panel2 = new JPanel();
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		JPanel panel3 = new JPanel(new BorderLayout());
		panel3.add(panel,BorderLayout.CENTER);
		panel3.add(panel2,BorderLayout.SOUTH);
		contenPane.add(panel3, BorderLayout.SOUTH);

		button1.addActionListener(new EventActionListener(table, txtHakbun, txtIrum, txtKor, txtEng, txtMath));
		button2.addActionListener(new EventActionListener(table));
		button3.addActionListener(new EventActionListener(table, txtHakbun, txtIrum, txtKor, txtEng, txtMath));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
