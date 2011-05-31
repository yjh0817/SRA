package com.cyrusian.academic.sra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;


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
	
//***************** ActionListener of MenuBar *****************
	private class exitaction implements ActionListener {
		public void actionPerformed (ActionEvent e){
			System.exit(0);
		}
	}
//**************************************************************
	public GUIManager() {
		super("SRA");
		setSize(640, 640); // why 900, 688?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(Color.BLACK);
		setVisible(true);
		
//***************** Menu Bar *********************
		
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);

		JMenu nMenu = new JMenu("Menu");
		menubar.add(nMenu);
		JMenuItem nMenu_com = new JMenuItem("New game (compuger)");
		JMenuItem nMenu_player = new JMenuItem("New game (player)");
		JMenuItem nMenu_giveup = new JMenuItem("Give up!!");
		JMenuItem nMenu_exit = new JMenuItem("Exit");
		nMenu.add(nMenu_com);
		nMenu.add(nMenu_player);
		nMenu.add(nMenu_giveup);
		nMenu.add(nMenu_exit);
		
		JMenu difMenu=new JMenu("Difficulty");
		menubar.add(difMenu);
		JMenuItem dif_easy=new JMenuItem("Easy");
		JMenuItem dif_mid=new JMenuItem("Middle");
		JMenuItem dif_hard=new JMenuItem("Hard");
		difMenu.add(dif_easy);
		difMenu.add(dif_mid);
		difMenu.add(dif_hard);
		
		nMenu_exit.addActionListener(new exitaction());
		
//****************** Game Board *******************
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