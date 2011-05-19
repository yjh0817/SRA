package com.cyrusian.academic.sra.i18n;


public class Internationalization {
	
	private static Internationalization SINGLETON = null;
	
	private Internationalization() {
		// singlton
	}
	
	public Internationalization getInstance() {
		if(SINGLETON == null)
			SINGLETON = new Internationalization();
		
		return SINGLETON;
	}
	
}
