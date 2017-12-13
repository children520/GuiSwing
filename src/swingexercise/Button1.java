package swingexercise;




import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import static net.mindview.util.SwingConsole.*;

public class Button1 extends JFrame{
	private JButton
	b1=new JButton("button 1"),
	b2=new JButton("button 2");
	public Button1() {
		//布局管理器
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}
	public static void main(String[] args) {
		run(new Button1(),200, 100);
	}

}
