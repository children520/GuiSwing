package swingexercise;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * 页签式的对话框
 */
public class TabbedPanel extends JFrame{
	private String[] flavors= {
			"Chocolate","Strawberry","Vanilla Fudge Swirl",
			"Mint Chip","Mocha Almond Fudge","Rum Raish",
			"Praline Cream","Mud Pie"};
	private JTabbedPane tabs=new JTabbedPane();
	private JTextField txt=new JTextField(20);
	//页签式显示到顶部
	public TabbedPanel() {
		int i=0;
		for(String flavor:flavors)
			tabs.addTab(flavors[i], new Button("Tabbed pane"+i++));
		tabs.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				txt.setText("Tab selected:"+tabs.getSelectedIndex());
				
			}
		});
		add(BorderLayout.SOUTH,txt);
		add(tabs);
	}
	public static void main(String[] args) {
		SwingConsole.run(new TabbedPanel(), 400, 300);
	}

}
