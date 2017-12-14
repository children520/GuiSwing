package swingexercise;

import java.awt.Color;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TraceEvent extends JFrame{
	private HashMap<String, JTextField> h=new HashMap<String,JTextField>();
	private String[] event= {"focusGained","focusLost","keyPressed","keyReleased",
			"mouseExited","mousePressed","mouseReleased","mouseDragged","mouseMoved"
	};
	private MyButton
		b1=new MyButton(Color.BLUE,"test1"),
		b2=new MyButton(Color.RED,"test2");
	
	class MyButton extends JButton{
		//传入事件的名称以及从事件得到的字符串
		void report(String field,String msg) {
			h.get(field).setText(msg);
		}
		FocusListener fl=new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				report("focusGained", e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				report("focusGained",e.paramString());
				// TODO Auto-generated method stub
				
			}
		};
		KeyListener kl=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				report("keyTyped",e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				report("keyReleased", e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				report("keyPressed", e.paramString());
				// TODO Auto-generated method stub
				
			}
		};
		MouseListener ml=new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				report("mouseReleased",e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				report("mousePressed",e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				report("mouseExited",e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				report("mouseEntered",e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				report("mouseClicked", e.paramString());
				// TODO Auto-generated method stub
				
			}
		};
		MouseMotionListener mml=new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				report("mouseMoved", e.paramString());
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				report("mouseDragged",e.paramString());
				// TODO Auto-generated method stub
				
			}
		};
		public MyButton(Color color,String label) {
			super(label);
			setBackground(color);
			addFocusListener(fl);
			addKeyListener(kl);
			addMouseListener(ml);
			addMouseMotionListener(mml);
		}
	}
	public TraceEvent() {
		setLayout(new GridLayout(event.length+1,2));
		for(String evt:event) {
			JTextField t=new JTextField();
			t.setEditable(false);
			add(new JLabel(evt,JLabel.RIGHT));
			add(t);
			h.put(evt, t);
			
		}
		add(b1);
		add(b2);
		
	}
	public static void main(String[] args) {
		SwingConsole.run(new TraceEvent(),700, 500);
	}
	

}
