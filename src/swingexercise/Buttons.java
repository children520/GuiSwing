package swingexercise;
import java.awt.FlowLayout;

/*
 * 几种按钮的使用
 */
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

public class Buttons extends JFrame{
	private JButton jb=new JButton("JButton");
	private BasicArrowButton 
		up=new BasicArrowButton(BasicArrowButton.NORTH),
		down=new BasicArrowButton(BasicArrowButton.SOUTH),
		right=new BasicArrowButton(BasicArrowButton.EAST),
		left=new BasicArrowButton(BasicArrowButton.WEST);
	public Buttons() {
		setLayout(new FlowLayout());
		add(jb);
		add(new JToggleButton("JToggleButton"));
		add(new JCheckBox("JCheckBox"));
		add(new JRadioButton("JRadioButton"));
		JPanel jp=new JPanel();
		jp.setBorder(new TitledBorder("direction"));
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		add(jp);
	}
	public static void main(String[] args) {
		SwingConsole.run(new Buttons(), 350, 200);
	}

}
