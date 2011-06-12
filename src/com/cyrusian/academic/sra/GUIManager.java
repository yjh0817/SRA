package com.cyrusian.academic.sra;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import com.cyrusian.academic.sra.element.ChessBoard;
import com.cyrusian.academic.sra.i18n.Internationalization;


public class GUIManager extends JFrame {
	
	private JButton[] theGrid;
	private Internationalization i18n;
	private int selected;
	private SRAMain delegate;
	private ChessEngine engietan;
	
	public GUIManager(SRAMain deleg) {
		super("SRA");
		delegate=deleg;
		i18n = Internationalization.getInstance();
		selected=-1;
	}
	
	public GUIManager prepare(ChessEngine engie) {
		engietan=engie;
		setSize(640, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(Color.BLACK);
		
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuGame = new JMenu(i18n.getString("MenuGame"));
		menuGame.setMnemonic(KeyEvent.VK_G);
		menuBar.add(menuGame);
		JMenuItem miNewSingle = new JMenuItem(i18n.getString("MenuGameNewSingle"));
		miNewSingle.setMnemonic(KeyEvent.VK_S);
		miNewSingle.addActionListener(new MenuListener(MenuType.NEW_SINGLE));
		menuGame.add(miNewSingle);
		/*
		JMenuItem miNewMulti = new JMenuItem(i18n.getString("MenuGameNewMulti"));
		miNewMulti.setMnemonic(KeyEvent.VK_M);
		miNewMulti.addActionListener(new MenuListener(MenuType.NEW_MULTI));
		miNewMulti.setEnabled(false); // not now.
		menuGame.add(miNewMulti);
		JMenuItem miJoinMulti = new JMenuItem(i18n.getString("MenuGameJoinMulti"));
		miJoinMulti.setMnemonic(KeyEvent.VK_J);
		miJoinMulti.addActionListener(new MenuListener(MenuType.NEW_JOIN));
		miJoinMulti.setEnabled(false); // not now.
		menuGame.add(miJoinMulti);
		menuGame.addSeparator();
		JMenuItem miGiveUp = new JMenuItem(i18n.getString("MenuGameGiveUp"));
		miGiveUp.setMnemonic(KeyEvent.VK_U);
		miGiveUp.addActionListener(new MenuListener(MenuType.CURRENT_GIVEUP));
		menuGame.add(miGiveUp);
		//*/
		menuGame.addSeparator();
		JMenuItem miExit = new JMenuItem(i18n.getString("MenuGameExit"));
		miExit.setMnemonic(KeyEvent.VK_X);
		miExit.addActionListener(new MenuListener(MenuType.EXIT_GAME));
		menuGame.add(miExit);
		
		JMenu menuDiff=new JMenu(i18n.getString("MenuDifficulty"));
		ButtonGroup diffGroup = new ButtonGroup();
		menuDiff.setMnemonic(KeyEvent.VK_D);
		menuBar.add(menuDiff);
		JRadioButtonMenuItem miDiffBasic=new JRadioButtonMenuItem(i18n.getString("MenuDifficultyBasic"));
		miDiffBasic.setMnemonic(KeyEvent.VK_B);
		miDiffBasic.addActionListener(new MenuListener(MenuType.DIFF_BAS));
		miDiffBasic.setSelected(true);
		diffGroup.add(miDiffBasic);
		menuDiff.add(miDiffBasic);
		JRadioButtonMenuItem miDiffAdvanced=new JRadioButtonMenuItem(i18n.getString("MenuDifficultyAdvanced"));
		miDiffAdvanced.setMnemonic(KeyEvent.VK_A);
		miDiffAdvanced.addActionListener(new MenuListener(MenuType.DIFF_ADV));
		diffGroup.add(miDiffAdvanced);
		menuDiff.add(miDiffAdvanced);
		JRadioButtonMenuItem miDiffExtreme=new JRadioButtonMenuItem(i18n.getString("MenuDifficultyExtreme"));
		miDiffExtreme.setMnemonic(KeyEvent.VK_E);
		miDiffExtreme.addActionListener(new MenuListener(MenuType.DIFF_EXT));
		diffGroup.add(miDiffExtreme);
		menuDiff.add(miDiffExtreme);
		
		setJMenuBar(menuBar);
		

		JPanel playGround = new JPanel();
		playGround.setLayout(new GridLayout(8, 8));
		
		theGrid = new JButton[64];
		for(int loopy = 0; loopy < 64; ++loopy) {
			theGrid[loopy] = new JButton();
			theGrid[loopy].addActionListener(new MoveListener(loopy));
			theGrid[loopy].setRolloverEnabled(false);
			theGrid[loopy].setBorderPainted(false);
			
			playGround.add(theGrid[loopy]);
		}
		add(playGround);
		pack(); // to calculate menuBar's height. NEVER USE pack() AGAIN AFTER THIS POINT!
		setSize(640, 640 + menuBar.getHeight());
		
		return this;
  	}
	
	public void updateBoard(ChessBoard currentBoard) {
		char[] allocation = currentBoard.getAllocation();
		
		int count=0;
		for(char ainfo:allocation) {
			StringBuilder fileName=new StringBuilder("imageresource/");
			
			switch(ainfo) {
				case 'b':
				case 'B':
					fileName.append("Bishop-");
					break;
				case 'k':
				case 'K':
					fileName.append("King-");
					break;
				case 'n':
				case 'N':
					fileName.append("Knight-");
					break;
				case 'p':
				case 'P':
					fileName.append("Pawn-");
					break;
				case 'q':
				case 'Q':
					fileName.append("Queen-");
					break;
				case 'r':
				case 'R':
					fileName.append("Rook-");
					break;
				default:
					fileName.append("Empty-");
					break;
			}
			if(Character.isUpperCase(ainfo)==true)
				fileName.append("White-");
			else if(Character.isLowerCase(ainfo)==true)
				fileName.append("Black-");
			
			if(((count - (count % 8)) / 8) % 2 == 0)
				fileName.append(count%2==0?"Even":"Odd");
			else
				fileName.append(count%2==1?"Even":"Odd");
			fileName.append(".png");
			
			//System.out.println(getClass().getResource(fileName.toString()).getPath());
			theGrid[count++].setIcon(new ImageIcon(getClass().getResource(fileName.toString()).getPath()));
			//count++;
		}
		//System.exit(1);
	}
	
	private class MoveListener implements ActionListener {
		
		private int coord;
		
		public MoveListener(int crd) {
			coord = crd;
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(selected == -1)
				selected = engietan.isWhite(coord) ? coord : -1;
			else {
				engietan.runEngieRun(selected, coord);
				selected = -1;
			}
		}
		
	}
	
	private class MenuListener implements ActionListener {
		
		private MenuType menuType;
		
		public MenuListener(MenuType type) {
			menuType = type;
		}
		
		@Override
		public void actionPerformed(ActionEvent ae){
			switch(menuType) {
				case NEW_SINGLE:
					delegate.newGame(engietan.getDifficulty());
					break;
				case NEW_MULTI:
					break;
				case NEW_JOIN:
					break;
				case CURRENT_GIVEUP:
					break;
				case EXIT_GAME:
					System.exit(0);
					break;
				case DIFF_BAS:
					engietan.setDifficulty(ChessEngine.Difficulty.BASIC);
					break;
				case DIFF_ADV:
					engietan.setDifficulty(ChessEngine.Difficulty.ADVANCED);
					break;
				case DIFF_EXT:
					engietan.setDifficulty(ChessEngine.Difficulty.EXTREME);
					break;
				
			}
		}
		
	}
	
	private enum MenuType {
		NEW_SINGLE, NEW_MULTI, NEW_JOIN, CURRENT_GIVEUP, EXIT_GAME, DIFF_BAS, DIFF_ADV, DIFF_EXT;
	}
	
}