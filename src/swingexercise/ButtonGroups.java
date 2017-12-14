package swingexercise;
/*
 * 排它按钮组
 * 一个面板几个按钮
 */
import java.awt.FlowLayout;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
	

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class ButtonGroups extends JFrame{
	private static String[] ids= {"June","Beaver","Wally","Eddie","Lumpy"};
	static JPanel makeBpanel(
		Class<? extends AbstractButton> kind,String[] ids){
			ButtonGroup bg=new ButtonGroup();
			JPanel jp=new JPanel();
			String title=kind.getName();
			//该对象表示的字符序列中字符最后出现的索引
			title=title.substring(title.lastIndexOf('.')+1);
			jp.setBorder(new TitledBorder(title));
			for(String id:ids) {
				AbstractButton ab=new JButton("failed");
				try {
					//Constructor构造器接受传递给getConstructor()的clas列表指定的类型
					Constructor ctor=kind.getConstructor(String.class);
					ab=(AbstractButton)ctor.newInstance(id);
				}catch (Exception e) {
					System.err.println("can't create"+kind);
					// TODO: handle exception
				}
				bg.add(ab);
				jp.add(ab);
			
		}
			return jp;
	}
	public ButtonGroups() {
		setLayout(new FlowLayout());
		add(makeBpanel(JButton.class, ids));
		add(makeBpanel(JToggleButton.class, ids));
		add(makeBpanel(JCheckBox.class, ids));
		add(makeBpanel(JRadioButton.class, ids));
	}
	public static void main(String[] args) {
		SwingConsole.run(new ButtonGroups(),500, 300);
	}

}
