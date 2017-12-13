package swingexercise;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
/*
 * 组件呈现合适的大小
 */

public class FlowLayout1 extends JFrame{
	public FlowLayout1() {
		setLayout(new FlowLayout());
		for(int i=0;i<20;i++) {
			add(new JButton("Button"+i));
		}
	}
		public static void main(String[] args) {
			SwingConsole.run(new FlowLayout1(), 300, 300);
		}
	}


