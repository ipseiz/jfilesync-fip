// JFSTextT.java

package com.fip.jfs.conf;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *  Translates the text of JFileSync windows. 
 *
 * @author Fabien Ipseiz
 * @version 8 févr. 2013
 */
public enum JFSTextTranslation {
	
	INSTANCE;
	
	/** The system's line separator. */
	//public final static String LINE_SEPARATOR = System.getProperty(
	//		"line.separator", "\n");

	/** Stores the system locale. */
	private Locale locale = null;

	/** Stores the resource bundle. */
	private ResourceBundle bundle = null;

	/**
	 * Sets some default values for the object.
	 */
	private JFSTextTranslation() {
		//locale = Locale.getDefault();
		locale = Locale.ENGLISH;
		bundle = ResourceBundle.getBundle(JFSConst.TRANSLATION_CLASS,locale);
	}

	/**
	 * Returns the reference of the only JFSText object.
	 * 
	 * @return The only JFSText instance.
	 */
	public final static JFSTextTranslation getInstance() {
		return INSTANCE;
	}

	/**
	 * Returns the translated string for a certain key.
	 * 
	 * @param key
	 *            The key.
	 * @return Translated string.
	 */
	public final String get(String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Gets the current locale.
	 * 
	 * @return The current locale.
	 */
	public final Locale getLocale() {
		return locale;
	}
	
}
