package swingexercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import javax.imageio.ImageTypeSpecifier;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*
 * 通知消息对话框
 */
public class MessageBoxes extends JFrame{
	private JButton[] b= {new JButton("Alert"),new JButton("Yes/no"),new JButton("Color"),
			new JButton("Input"),new JButton("3 vals")};
	private JTextField txt=new JTextField(15);
	private ActionListener al=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id =((JButton)e.getSource()).getText();
			if(id.equals("Alert"))
				//消息对话框
				JOptionPane.showMessageDialog(null, "there's a bug on you","hey",JOptionPane.ERROR_MESSAGE);
			else if(id.equals("Yes/no"))
				//确认对话框
				JOptionPane.showConfirmDialog(null, "or no","choose yes",JOptionPane.YES_NO_CANCEL_OPTION);
			else if(id.equals("Color")) {
				Object[] options= {"Red","Green"};
				int sel=JOptionPane.showOptionDialog(null, "Choose a Color","Warning ", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);
				if (sel!=JOptionPane.CLOSED_OPTION) 
					txt.setText("Color Selected :"+options[sel]);
				}else if(id.equals("Input")) {
					//输入对话框
					String val=JOptionPane.showInputDialog("how many fingers do you see?");
					txt.setText(val);
				
					}
				else if(id.equals("3 Vals")) {
					Object[] selections= {"First","Second","Thrid"};
					Object val=JOptionPane.showInputDialog(null, "Choose one", "Input", 
							JOptionPane.INFORMATION_MESSAGE, null, selections, selections[0]);
					if(val!=null)
						txt.setText(val.toString());
				}
		}
	};
	public MessageBoxes() {
		setLayout(new FlowLayout());
		for(int i=0;i<b.length;i++) {
			b[i].addActionListener(al);
			add(b[i]);
		}
		add(txt);
	}
	public static void main(String[] args) {
		SwingConsole.run(new MessageBoxes(),500, 500);
	}

}
