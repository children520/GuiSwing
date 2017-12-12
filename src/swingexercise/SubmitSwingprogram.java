package swingexercise;

import java.awt.Frame;
import java.awt.Label;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SubmitSwingprogram extends JFrame{
	JLabel label;
	public SubmitSwingprogram() {
		super("hello world");
		label=new JLabel("a label");
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300,500);
	}
	static SubmitSwingprogram ssp;
	public static void main(String[] args) throws Exception{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				 ssp=new SubmitSwingprogram();
				
			}
		});
		//不能放构造器内部，否则会终止线程
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ssp.label.setText("hey this is different");
				// TODO Auto-generated method stub
				
			}
		});
	}

}
