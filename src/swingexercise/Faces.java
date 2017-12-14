package swingexercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Faces extends JFrame {
	private static Icon[] faces;
	private JButton jb,jb2=new JButton("Disable");
	private boolean mad=false;
	public Faces() {
		faces=new Icon[] {
				new ImageIcon(getClass().getResource("/Face.png")),
				new ImageIcon(getClass().getResource("/Face.png")),
				new ImageIcon(getClass().getResource("/Face.png")),
				new ImageIcon(getClass().getResource("/Face.png")),
				new ImageIcon(getClass().getResource("/Face.png")),
				
		};
		jb=new JButton("JButton",faces[3]);
		setLayout(new FlowLayout());
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mad) {
					jb.setIcon(faces[3]);
					mad=false;
				}else {
					jb.setIcon(faces[0]);
					mad=true;
				}
				jb.setVerticalAlignment(JButton.TOP);
				jb.setHorizontalAlignment(JButton.LEFT);
				// TODO Auto-generated method stub
				
			}
		});
		jb.setRolloverEnabled(true);
		jb.setRolloverIcon(faces[1]);
		jb.setPressedIcon(faces[2]);
		jb.setDisabledIcon(faces[4]);
		jb.setToolTipText("Yow!");
		add(jb);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jb.isEnabled()) {
					jb.setEnabled(false);
					jb2.setText("enable");
				}else {
					jb.setEnabled(true);
					jb2.setText("disable");
				}
				// TODO Auto-generated method stub
				
			}
		});
		add(jb2);
	}
	public static void main(String[] args) {
		SwingConsole.run(new Faces(), 250, 125);
	}

}
