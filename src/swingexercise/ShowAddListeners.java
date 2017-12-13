package swingexercise;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * 输入Swing组件的名称，
 * 查找的结果使用正则表达式表示，
 * 最终结果现在在文本区域
 */
public class ShowAddListeners extends JFrame{
	private JTextField name=new JTextField(25);
	private JTextArea results=new JTextArea(40,65);
	private static Pattern addListener=Pattern.compile("(add\\w+?Listener\\(.?\\))");
	private static Pattern qualifier=Pattern.compile("\\w+\\.");
	class NameL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nm=name.getText().trim();//删除前部空格和尾部空格
			if(nm.length()==0) {
				results.setText("No Match");
				return;
			}
			Class<?> kind;
			try {
				kind=Class.forName("javax.swing."+nm);
			}catch (ClassNotFoundException ex) {
				results.setText("No match");
				return;
				// TODO: handle exception
			}
			Method[] methods=kind.getMethods();
			results.setText("");
			for(Method m:methods) {
				//寻找匹配的对象
				Matcher matcher=addListener.matcher(m.toString());
				//如果匹配的对象找到，则添加
				if(matcher.find())
					results.append(qualifier.matcher(matcher.group(1)).replaceAll("")+"\n");
			}
		}
	}
	public ShowAddListeners() {
		NameL nameListener=new NameL();
		name.addActionListener(nameListener);
		JPanel top=new JPanel();
		top.add(new JLabel("Swing class name(press Enter):"));
		top.add(name);
		add(BorderLayout.NORTH,top);
		add(new JScrollPane(results));
		//设置初始值进行一次测试
		name.setText("JTextArea");
		nameListener.actionPerformed(new ActionEvent("",0, ""));
		
	}
	public static void main(String[] args) {
		SwingConsole.run(new ShowAddListeners(), 500, 400);
	}

}
