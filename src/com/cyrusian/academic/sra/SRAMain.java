package com.cyrusian.academic.sra;

//@ Classes
//import com.cyrusian.academic.sra.element.ChessPiece;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.LogManager;
import javax.swing.UIManager;
import com.cyrusian.academic.sra.i18n.Internationalization;


public class SRAMain {
	
	private GUIManager mainWindow;
	private ChessEngine engietan;
	
	private SRAMain() {
		mainWindow = new GUIManager();
		engietan = new ChessEngine();
	}
	
	private void powerUp() {
		engietan.runEngieRun();
		mainWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
		//LogManager sharedManager=LogManager.getLogManager(); // do we need this?
		Internationalization i18n = Internationalization.getInstance(); //@ Will load messages using system locale.
		Logger rootLevelLogger = Logger.getLogger("kr.cyrush.academic.sra");

		try {		
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //@ This will make our Java application look like native to each OS.
		} catch(Exception e) {
			rootLevelLogger.log(Level.WARNING, i18n.getString("ApplyingSystemUIFailed"));
		}
		
		
		new SRAMain().powerUp();
	}
	
}