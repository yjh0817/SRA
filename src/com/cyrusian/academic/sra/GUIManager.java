package com.cyrusian.academic.sra;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIManager implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		int x = b.getX()/80;
		int y = b.getY()/80;
		System.out.println("X : " + x + "  Y : " + y);
	}

	public void go() {
		JFrame frame = new JFrame("SRA - Stalemate Resolution Associate");
		ImageIcon icon = new ImageIcon("C:/Users/user/Documents/NetBeansProjects/SRA/src/com/cyrusian/academic/sra/panelImage.png");
		JButton b[] = new JButton[64];

		JPanel panel1 = new JPanel();
		JPanel back = new JPanel();
		JPanel playground = new JPanel();
                JImagePanel panel2 = new JImagePanel(icon.getImage());
                
		panel1.setBackground(Color.black);
		panel2.setBackground(Color.lightGray);
                
		playground.setBackground(Color.white);
                
		panel1.setBounds(0, 0, 650, 650);
		panel2.setBounds(650,0,250,650);
                
		playground.setBounds(5,5,640,640);

		panel1.setVisible(true);
		panel2.setVisible(true);

		frame.add(back);
		frame.add(playground);
		frame.add(panel1);
		frame.getContentPane().add(panel2);

		playground.setLayout(new GridLayout(8,8));
		int count=0;
		for(int i = 0 ; i < 64 ; i++) {
			if(count==0) {
				b[i] = new JButton(new ImageIcon("C:/Users/user/Documents/NetBeansProjects/SRA/src/com/cyrusian/academic/sra/Chess-Brown.png"));
				b[i].setBackground(Color.black);
                                if((i!=15) && (i!=31) && (i!=47))
					count=1;
			}
			else if(count==1) {
				b[i] = new JButton(new ImageIcon("C:/Users/user/Documents/NetBeansProjects/SRA/src/com/cyrusian/academic/sra/Chess-LightBrown.png"));
				b[i].setBackground(Color.white);
                                
				if((i!=7) && (i!=23) && (i!=39) && (i!=55))
                                    count=0;
			}
			b[i].setRolloverEnabled(false);
			b[i].setBorderPainted(false);

			playground.add(b[i]);
		}

		frame.setSize(900,688);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GUIManager listener = new GUIManager();
		for(int i = 0; i<64; i++)
			b[i].addActionListener(listener);
  	}
}