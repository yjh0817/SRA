package kr.cyrush.academic.sra;

//@ Classes
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.LogManager;
import javax.swing.UIManager;
//@ Exceptions
import java.util.MissingResourceException;


public class SRAMain {
	
	private SRAMain() {
		// init
	}
	
	private void powerUp() {
		// start!
	}
	
	public static void main(String[] args) {
		//LogManager sharedManager=LogManager.getLogManager(); // do we need this?
		Logger rootLevelLogger;
		
		try {
			rootLevelLogger=Logger.getLogger("kr.cyrush.academic.sra", new StringBuilder("kr.cyrush.academic.sra.i18n.").append(Locale.getDefault().getISO3Language()).toString()); //@ Attempt to pull out resources for system native locale
		} catch(MissingResourceException mre) {
			rootLevelLogger=Logger.getLogger("kr.cyrush.academic.sra", "kr.cyrush.academic.sra.i18n.eng"); //@ When fails, just load resources for English
			
			rootLevelLogger.log(Level.WARNING, "UserLocaleNotSupportedExplicitly");
		}
		
		try {		
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //@ This will make our Java application look like native to each OS.
		} catch(Exception e) {
			rootLevelLogger.log(Level.WARNING, "ApplyingSystemUIFailed");
		}
		
		new SRAMain().powerUp();
	}
	
}