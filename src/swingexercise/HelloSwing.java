package swingexercise;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing {
	public static  void main(String[] args) throws Exception{
		JFrame frame=new JFrame("hello world");
		JLabel label=new JLabel("a label");
		frame.add(label);
		//退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//尺寸
		frame.setSize(300, 100);
		//显示
		frame.setVisible(true);
		TimeUnit.SECONDS.sleep(1);
		label.setText("hey this is different");
	}

}
