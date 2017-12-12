package swingexercise;

import java.awt.Label;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SubmitLabelManipulationTask {
	public static void main(String[] args) throws Exception{
		JFrame frame =new JFrame("hello world");
		final JLabel label=new JLabel("a label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,500);
		frame.setVisible(true);
		TimeUnit.SECONDS.sleep(1);
		//提交任务，不产生冲突
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				label.setText("hey this is different");
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
