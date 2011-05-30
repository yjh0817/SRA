package com.cyrusian.academic.sra;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIManager extends JFrame {
	
	private JButton[] theGrid;
	
	private class MoveListener implements ActionListener {
		
		private int coord;
		
		public MoveListener(int crd) {
			coord = crd;
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println(coord);
		}
		
	}

	public GUIManager() {
		super("SRA");
		setSize(640, 640); // why 900, 688?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(Color.BLACK);
		
		JPanel playGround = new JPanel();
		playGround.setLayout(new GridLayout(8, 8));
		
		// prepare images
		URL btnOdd = getClass().getResource("imageresource/Chess-Brown.png"),
		btnEven = getClass().getResource("imageresource/Chess-LightBrown.png");
		
		theGrid = new JButton[64];
		for(int loopy = 0; loopy < 64; ++loopy) {
			if(((loopy - (loopy % 8)) / 8) % 2 == 0) {
				if(loopy%2 == 0)
					theGrid[loopy] = new JButton(new ImageIcon(btnEven));
				else
					theGrid[loopy] = new JButton(new ImageIcon(btnOdd));
			} else {
				if(loopy%2 == 0)
					theGrid[loopy] = new JButton(new ImageIcon(btnOdd));
				else
					theGrid[loopy] = new JButton(new ImageIcon(btnEven));
			}
			theGrid[loopy].addActionListener(new MoveListener(loopy));
			theGrid[loopy].setRolloverEnabled(false);
			theGrid[loopy].setBorderPainted(false);
			
			playGround.add(theGrid[loopy]);
		}
		add(playGround);
  	}
	
}