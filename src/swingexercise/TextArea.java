package swingexercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.mindview.util.*;


public class TextArea extends JFrame{
	private JButton
	b=new JButton("add data"),
	c=new JButton("clear data");
	private JTextArea t =new JTextArea(20,40);
	private Map<String,String> m=new HashMap<String,String>();
	public TextArea() {
		m.putAll(Countries.capitals());
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//entrySet:该地图中包含的映射的集合视图
				//Entry:该条目对应的键
				for(Map.Entry me:m.entrySet())
					t.append(me.getKey()+":"+me.getValue()+"\n");
			}
		});
		c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText("");
				
			}
		});
		setLayout(new FlowLayout());
		//进行滚动控制
		add(new JScrollPane(t));
		add(b);
		add(c);
	}
	public static void main(String[] args) {
		SwingConsole.run(new TextArea(), 475, 425);
	}
	

}
