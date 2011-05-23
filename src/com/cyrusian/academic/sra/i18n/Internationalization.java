package com.cyrusian.academic.sra.i18n;

//@ Classes
import java.util.Locale;
import java.util.ResourceBundle;
//@ Exceptions
import java.util.MissingResourceException;


public class Internationalization {
	
	private static Internationalization SINGLETON = null;
	
	private Locale locSetting;
	private ResourceBundle resBundle;
	
	private Internationalization(Locale loc) {
		locSetting = loc;
		try {
			resBundle = ResourceBundle.getBundle("i18n", loc);
		} catch(MissingResourceException mre) {
			resBundle = ResourceBundle.getBundle("i18n", Locale.ENGLISH);
		}
	}
	
	public static Internationalization getInstance() {
		return getInstance(Locale.getDefault());
	}
	
	public static Internationalization getInstance(Locale loc) {
		if(SINGLETON == null) {
			if(loc == null)
				SINGLETON = new Internationalization(Locale.getDefault());
			else
				SINGLETON = new Internationalization(loc);
		}
		
		return SINGLETON;
	}
	
	public String getString(String key) {
		String ret = null;
		try {
			ret = resBundle.getString(key);
		} catch(Exception e) {
			// just nothing!
		}
		
		return ret;
	}
	
}
