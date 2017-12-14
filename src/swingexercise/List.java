package swingexercise;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/*
 * 列表框的使用
 * JFrame的使用出错
 */
public class List extends JFrame{
	private int count=0;
	private String[] flavors= {
			"Chocolate","Strawberry","Vanilla Fudge Swirl",
			"Mint Chip","Mocha Almond Fudge","Rum Raisin",
			"Praline Cream","Mud Pie"
	
	};
	private DefaultButtonModel lItems=new DefaultButtonModel();
	private JList lst=new JList((ListModel) lItems);
	private JTextArea t=new JTextArea(flavors.length,20);
	private JButton b=new JButton("add item");
	private ActionListener bl=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(count<flavors.length) {
				lItems.add(0,flavors[count++]);
			}
			else {
				b.setEnabled(false);
			}
		}
		
	};
	private ListSelectionListener ll=
			new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if(e.getValueIsAdjusting()) return;
					t.setText("");
					for(Object item:lst.getSelectedValue())
						t.append(item+"\n");
					
				}
			};
			public List() {
				t.setEditable(false);
				setLayout(new FlowLayout());
				Border brd=BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
				lst.setBorder(brd);
				for(int i=0;i<4;i++)
					lItems.addElement(flavors[count++]);
				add(t);
				add(lst);
				add(b);
				lst.addActionListener(bl);
			}
			public static void main(String[] args) {
				SwingConsole.run(new List(), 250, 375);
			}

}
