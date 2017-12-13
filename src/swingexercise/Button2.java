package swingexercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import static net.mindview.util.SwingConsole.*;

public class Button2 extends JFrame{
	private JButton
	b1=new JButton("button 1"),
	b2=new JButton("button 2");
	//输入文本
	private JTextField txt=new JTextField(10);
	//实现ActionListener接口，按下按钮回调actionPerformded
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name=((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	}
	private ButtonListener bl=new ButtonListener();
	public Button2() {
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(txt);
	}
	public static void main(String[] args) {
		run(new Button2(), 200, 150);
	}
	

}
