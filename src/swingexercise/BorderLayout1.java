package swingexercise;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.mindview.util.New;
/*
 * 设置默认的布局
 * 为5个按钮指定相应的位置
 */
public class BorderLayout1 extends JFrame {
	public BorderLayout1() {
		add(BorderLayout.NORTH,new JButton("North"));
		add(BorderLayout.SOUTH,new JButton("South"));
		add(BorderLayout.EAST,new JButton("EAST"));
		add(BorderLayout.WEST,new JButton("WEST"));
		add(BorderLayout.CENTER, new JButton("Center"));
	}
	public static void main(String[] args) {
		SwingConsole.run(new BorderLayout1(), 300, 250);
	}

}
