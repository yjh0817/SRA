package com.cyrusian.academic.sra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.*;


public class GUIManager extends JFrame {
	
	private JButton[] theGrid;
	
	public GUIManager() {
		super("SRA");
		setSize(640, 640); // why 900, 688?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(Color.BLACK);
		
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuGame = new JMenu("Game");
		menuGame.setMnemonic(KeyEvent.VK_G);
		menuBar.add(menuGame);
		JMenuItem miNewSingle = new JMenuItem("New Singleplayer");
		miNewSingle.setMnemonic(KeyEvent.VK_S);
		miNewSingle.addActionListener(new MenuListener(MenuType.NEW_SINGLE));
		menuGame.add(miNewSingle);
		JMenuItem miNewMulti = new JMenuItem("New Multiplayer");
		miNewMulti.setMnemonic(KeyEvent.VK_M);
		miNewMulti.addActionListener(new MenuListener(MenuType.NEW_MULTI));
		menuGame.add(miNewMulti);
		menuGame.addSeparator();
		JMenuItem miGiveUp = new JMenuItem("Give Up");
		miGiveUp.setMnemonic(KeyEvent.VK_U);
		miGiveUp.addActionListener(new MenuListener(MenuType.CURRENT_GIVEUP));
		menuGame.add(miGiveUp);
		menuGame.addSeparator();
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.setMnemonic(KeyEvent.VK_X);
		miExit.addActionListener(new MenuListener(MenuType.EXIT_GAME));
		menuGame.add(miExit);
		
		JMenu menuDiff=new JMenu("Difficulty");
		menuDiff.setMnemonic(KeyEvent.VK_D);
		menuBar.add(menuDiff);
		JMenuItem miDiffBasic=new JMenuItem("Basic");
		miDiffBasic.setMnemonic(KeyEvent.VK_B);
		menuDiff.add(miDiffBasic);
		JMenuItem miDiffAdvanced=new JMenuItem("Advanced");
		miDiffAdvanced.setMnemonic(KeyEvent.VK_A);
		menuDiff.add(miDiffAdvanced);
		JMenuItem miDiffExtreme=new JMenuItem("Extreme");
		miDiffExtreme.setMnemonic(KeyEvent.VK_E);
		menuDiff.add(miDiffExtreme);
		
		setJMenuBar(menuBar);
		

		
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
		pack(); // to calculate menuBar's height. NEVER USE pack() AGAIN AFTER THIS POINT!
		this.setSize(640, 640 + menuBar.getHeight());
		
  	}
	
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
	
	private class MenuListener implements ActionListener {
		
		private MenuType menuType;
		
		public MenuListener(MenuType type) {
			menuType = type;
		}
		
		@Override
		public void actionPerformed(ActionEvent ae){
			//
		}
		
	}
	
	public enum MenuType {
		NEW_SINGLE, NEW_MULTI, CURRENT_GIVEUP, EXIT_GAME, DIF_BASIC, DIF_ADV, DIF_EXT;
	}
	
}